package com.neu.hikari.demo.modules.data;


import com.neu.hikari.demo.common.util.UUIDGenerator;
import com.neu.hikari.demo.modules.data.entity.User;
import com.neu.hikari.demo.modules.data.service.IUserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    IUserService userService;

//    @Test
    public void addUser() {
        User u = new User();
        u.setId(UUIDGenerator.getUUID());
        u.setName("老牛");
        u.setCreateTime(LocalDateTime.now());

        userService.addUser(u);

        User after = userService.getById(u.getId());
        Assert.assertEquals(after.getName(), u.getName());
//        userService.removeById(u.getId());
    }

    @Test
    public void addUserMore() {
        long start  = System.currentTimeMillis();

        userService.addUserMore();

        long usetime = System.currentTimeMillis() - start;
        System.out.println("use time : " + usetime);

    }

}
