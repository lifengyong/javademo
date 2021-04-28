package com.neu.hikari.demo.modules.data.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neu.hikari.demo.modules.data.entity.User;
import com.neu.hikari.demo.modules.data.mapper.UserMapper;
import com.neu.hikari.demo.modules.data.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public void addUser(User user) {
        super.save(user);
    }
}
