package com.neu.hikari.demo.modules.data.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neu.hikari.demo.modules.data.entity.User;

public interface IUserService extends IService<User> {
    void addUser(User user);
}
