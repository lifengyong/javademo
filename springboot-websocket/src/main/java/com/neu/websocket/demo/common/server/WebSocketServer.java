package com.neu.websocket.demo.common.server;


import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint("/websocket/{sid}")
@Component
public class WebSocketServer {
    Log log = LogFactory.get();
    /**静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。*/
    private static AtomicInteger onlineNum = new AtomicInteger();
    /**concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。*/
    private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
    /**与某个客户端的连接会话，需要通过它来给客户端发送数据*/
    private Session session;
    /**接收频道sid*/
    private String sid = "";

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        this.session = session;
        this.sid = sid;
        if(webSocketMap.containsKey(sid)){
            webSocketMap.remove(sid);
            //加入set中
            webSocketMap.put(sid, this);
        }else{
            //加入set中
            webSocketMap.put(sid, this);
            //在线数加1
            addOnlineCount();
        }

        log.info("新客户端接入频道{}, 当前在线数为:{}", sid, getOnlineCount());

        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error(e, "新客户端接入频道{}异常", sid);
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if(webSocketMap.containsKey(sid)){
            //从set中删除
            webSocketMap.remove(sid);
            subOnlineCount();
            log.info("客户端退出频道{},当前在线数为:{}", sid, getOnlineCount());
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("来自频道{}的客户端消息:{}", sid, message);
        //可以群发消息
        if(StrUtil.isNotBlank(message)){
            try {
                //解析发送的报文
                JSONObject jsonObject = new JSONObject(message);
                //追加发送的客户端
                jsonObject.set("fromSid", this.sid);
                String toSid = jsonObject.getStr("toSid");
                //传送给对应toUserId用户的websocket
                if(StrUtil.isNotBlank(toSid) && webSocketMap.containsKey(toSid)){
                    webSocketMap.get(toSid).sendMessage(jsonObject.toStringPretty());
                } else {
                    log.info("无具体请求的sid，群发消息：{}", message);
                }
            } catch (Exception e){
                log.error(e);
            }
        }
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("客户端{}错误,原因:{}", this.sid, error.getMessage());
        log.error(error);
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 往指定频道发送消息
     */
    public void sendInfo(String message, @PathParam("sid") String sid) throws IOException {
        log.info("发送消息到客户端:{}，报文:{}", sid, message);
        if(StrUtil.isNotBlank(sid) && webSocketMap.containsKey(sid)){
            webSocketMap.get(sid).sendMessage(message);
        }else{
            log.error("客户端{}不在线！", sid);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineNum.get();
    }

    public static synchronized void addOnlineCount() {
        onlineNum.incrementAndGet();
    }

    public static synchronized void subOnlineCount() {
        onlineNum.decrementAndGet();
    }
}
