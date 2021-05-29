package com.neu.lify.demo.mybatisplus.module.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neu.lify.demo.mybatisplus.module.user.entity.User;
import com.neu.lify.demo.mybatisplus.module.user.mapper.UserMapper;
import com.neu.lify.demo.mybatisplus.module.user.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public void addUser(User user) {
        super.save(user);
    }

    @Override
    public List<User> getUsers() {
        return super.list();
    }

}
