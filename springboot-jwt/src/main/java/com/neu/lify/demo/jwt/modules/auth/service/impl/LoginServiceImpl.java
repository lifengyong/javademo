package com.neu.lify.demo.jwt.modules.auth.service.impl;

import com.neu.lify.demo.jwt.common.util.JwtAuth0Utils;
import com.neu.lify.demo.jwt.common.util.JwtUtil;
import com.neu.lify.demo.jwt.modules.auth.service.LoginService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Value("${jwt.key}")
    private String jwtKey;

    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> result = new HashMap<>();

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        claims.put("level", 20);//增加个key，测试用

        //jjwt
//        String token = JwtUtil.generate(claims);

        //auth0
        String token = JwtAuth0Utils.sign(jwtKey, claims);

        result.put("token", token);
        result.put("status", "ok");
        result.put("msg", "生成token成功");

        return result;
    }
}
