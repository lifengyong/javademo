package com.neu.lify.data.batch.insert.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neu.lify.data.batch.insert.entity.User;
import com.neu.lify.data.batch.insert.mapper.UserMapper;
import com.neu.lify.data.batch.insert.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {

    ExecutorService pool = Executors.newFixedThreadPool(10);

    @Override
    public void addUser(User user) {
        super.save(user);
    }

    /**
     * 多线程添加用户测试
     */
    @Override
    public void addUserMore() {

    }

}
