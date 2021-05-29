package com.neu.lify.demo.mybatisplus.module.user;


import com.neu.lify.demo.mybatisplus.module.user.entity.User;
import com.neu.lify.demo.mybatisplus.module.user.mapper.UserMapper;
import com.neu.lify.demo.mybatisplus.module.user.service.IUserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getListUser() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(1, userList.size());
        userList.forEach(System.out::println);
    }


}
