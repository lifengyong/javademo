package com.neu.websocket.demo.modules.user.controller;

import cn.hutool.core.io.FileUtil;
import com.neu.websocket.demo.common.model.Result;
import com.neu.websocket.demo.common.server.WebSocketServer;
import com.neu.websocket.demo.modules.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/addUser")
    @ResponseBody
    public String addUser() {
        log.info("addUser");
        return "ok";
    }

    @GetMapping("/sendMessage")
    @ResponseBody
    public String sendMessage() {
        String msg = "sengMessage OK";
        String sid = "abc";
        WebSocketServer.sendMessageToSid(msg, sid);
        log.info("sendMessage:{}", msg);
        return "ok";
    }

    @GetMapping("/sendObject")
    @ResponseBody
    public String sendObject() {
        User user = new User();
        user.setName("杨");
        user.setAge(23);
        user.setPhone("13566668888");

        Result result = new Result(user);

        String sid = "abc";
        WebSocketServer.sendObjectToSid(result, sid);
        log.info("sendObject:{}", user);
        return "ok";
    }

    @GetMapping("/sendBinary")
    @ResponseBody
    public String sendBinary() throws IOException {
        String path = "D:/picture/211_V.jpg";

        ByteBuffer buffer = getByteBuffer(path);

        String sid = "abc";
        WebSocketServer.sendBinaryToSid(buffer, sid);
        buffer.clear();
        log.info("sendBinary");

        return "ok";
    }

    public ByteBuffer getByteBuffer(String filePaht) throws IOException {
         ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10); //100kbytes
         FileChannel readChannel = FileChannel.open(new File(filePaht).toPath());
         int read;
         while ((read = readChannel.read(byteBuffer)) != -1) {
             //buffer从读切换到写
             byteBuffer.flip();
         }
//         readChannel.close();

         return byteBuffer;
    }

}
