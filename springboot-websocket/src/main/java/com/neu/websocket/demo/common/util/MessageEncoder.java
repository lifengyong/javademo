package com.neu.websocket.demo.common.util;


import cn.hutool.json.JSONUtil;
import com.neu.websocket.demo.common.model.Result;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<Result> {

    @Override
    public String encode(Result message) {

        return JSONUtil.toJsonStr(message);
    }

    @Override
    public void init(EndpointConfig ec) {
        System.out.println("MessageEncoder - init method called");
    }

    @Override
    public void destroy() {
        System.out.println("MessageEncoder - destroy method called");
    }
}


