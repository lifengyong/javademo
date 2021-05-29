package com.neu.lify.demo.mybatisplus.module.user;


import com.neu.lify.demo.mybatisplus.module.user.entity.User;
import com.neu.lify.demo.mybatisplus.module.user.service.IUserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    IUserService userService;

    @Test
    public void addUser() {
        User u = new User();
        u.setName("老牛");
        u.setCreateTime(LocalDateTime.now());

        userService.addUser(u);

        User after = userService.getById(u.getId());
        Assert.assertEquals(after.getName(), u.getName());
//        userService.removeById(u.getId());
    }


}
