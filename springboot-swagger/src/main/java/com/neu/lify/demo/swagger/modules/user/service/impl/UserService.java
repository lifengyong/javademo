package com.neu.lify.demo.swagger.modules.user.service.impl;

import com.neu.lify.demo.swagger.modules.user.model.User;
import com.neu.lify.demo.swagger.modules.user.service.IUserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService implements IUserService {

    @Override
    public User createUser() {
        User u = new User();
        u.setName("老牛");
        u.setAddress("上海市张江经济技术开发区");
        u.setIdno("110221196002061256");
        u.setPhone("01087260266");
        u.setSex("m");
        u.setRemark("" + System.currentTimeMillis());
        u.setCreateTime(LocalDateTime.now());

        return u;
    }
}
