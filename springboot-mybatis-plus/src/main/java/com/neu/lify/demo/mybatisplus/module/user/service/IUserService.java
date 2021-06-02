package com.neu.lify.demo.mybatisplus.module.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neu.lify.demo.mybatisplus.module.user.entity.User;
import com.neu.lify.demo.mybatisplus.module.user.model.UserQuery;
import com.neu.lify.demo.mybatisplus.module.user.model.UserResult;

import java.util.List;

public interface IUserService extends IService<User> {
    void addUser(User user);

    List<User> getUsers();

    IPage<UserResult> selectUserPage(UserQuery userQuery);

}
