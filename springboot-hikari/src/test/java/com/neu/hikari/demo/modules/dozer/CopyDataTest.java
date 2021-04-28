package com.neu.hikari.demo.modules.dozer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CopyDataTest {
    @Autowired
    private CopyData cd;

    @Test
    public void userCopy() {
        UserSource us = new UserSource();
        us.setName("老牛");
        us.setAddress("牛窝");

        UserTarget ut = cd.CopyUser(us);
        Assert.assertEquals(us.getName(), ut.getName());
        Assert.assertEquals(us.getAddress(), ut.getAddress());

    }

}
