package com.neu.hikari.demo.modules.log.controller;

import com.neu.hikari.demo.modules.log.service.ILogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    ILogService logService;

    @GetMapping("/writeLog")
    @ResponseBody
    public String queryUserById(){
        logService.addLog();
        return "ok";
    }

}
