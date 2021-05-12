package com.neu.hikari.demo.modules.log;

import com.neu.hikari.demo.modules.log.service.ILogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogServiceTest {
    @Autowired
    ILogService logService;

    @Test
    public void addLog() {
        logService.addLog();
    }

//    @Test
    public void addLogMore() {
        logService.addLogMore();
    }
}
