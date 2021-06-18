package com.neu.websocket.demo.common.util;


import cn.hutool.json.JSONUtil;
import com.neu.websocket.demo.common.model.Result;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text<Result> {

    @Override
    public Result decode(String jsonMessage) throws DecodeException {
        return JSONUtil.toBean(jsonMessage, Result.class);
    }

    @Override
    public boolean willDecode(String jsonMessage) {
        try {
            return JSONUtil.isJson(jsonMessage);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void init(EndpointConfig ec) {
        System.out.println("MessageDecoder -init method called");
    }

    @Override
    public void destroy() {
        System.out.println("MessageDecoder - destroy method called");
    }

}
