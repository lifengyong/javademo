package com.neu.lify.data.batch.module.insert;


import com.neu.lify.data.batch.common.util.UUIDGenerator;
import com.neu.lify.data.batch.module.insert.entity.User;
import com.neu.lify.data.batch.module.insert.service.IUserService;
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

//    @Test
    public void addUserMore() {
        userService.addUserMore();
    }

    @Test
    public void addUserMillion() {
        userService.addUserTenMillion();
    }

}
