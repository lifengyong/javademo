package com.neu.lify.demo.mybatisplus.module.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neu.lify.demo.mybatisplus.module.user.entity.User;

import java.util.List;

public interface IUserService extends IService<User> {
    void addUser(User user);

    List<User> getUsers();

}
