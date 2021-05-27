package com.neu.lify.demo.jwt.common.intercept;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.lify.demo.jwt.common.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //OPTIONS请求不做拦截操作:进行跨域请求的时候，并且请求头中有额外参数，比如token，客户端会先发送一个OPTIONS请求
        if(RequestMethod.OPTIONS.name().equals(request.getMethod())) {
            return true;
        }

        //Authorization为与前端程序商定的字段
        String token = request.getHeader("Authorization");
        response.setStatus(401);

        //检验token的有效性
        if (StringUtils.isBlank(token)) {
            responseMessage(response, "token不能为空");
            return false;
        }

        String msg = "";
        try {
            boolean verify = JwtUtil.verify(token);
            if (verify) {
//                System.out.println("验证通过");
                response.setStatus(200);

                Claims claims = JwtUtil.getClaim(token);
                String username = (String)claims.get("username");
                System.out.println("username: " + username);

                return true; // 通过验证
            }
        } catch (SignatureException e) {
            msg = "无效签名";
        } catch (UnsupportedJwtException e) {
            msg = "不支持的签名";
        } catch (ExpiredJwtException e) {
            msg = "token过期";
        } catch (MalformedJwtException e) {
            msg = "不支持的签名格式";
        } catch (Exception e) {
            msg = "token无效";
        }

        Map<String, Object> map = new HashMap<>();
        map.put("mag", msg);
        map.put("status", false);

        // 将map转为json
        String json = new ObjectMapper().writeValueAsString(map);
        responseMessage(response, json);

        return false;
    }

    /**
     * 返回消息给前端
     * @param response
     * @param message
     * @throws IOException
     */
    private void responseMessage(HttpServletResponse response, String message) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(message);
    }

}
