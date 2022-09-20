package com.neu.lify.jdbc.procedure;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class ProcedureApplicationTests {

    private long time;

    @Test
    void contextLoads() {
    }

    @Before
    public void startUp() {
        this.time = System.currentTimeMillis();
        log.info("Spring boot jdbc test start--------->");
    }

    @After
    public void stopTest() {
        log.info("Spring boot jdbc test end---------<>, 用时: {} ms", System.currentTimeMillis() - this.time);
    }
}
