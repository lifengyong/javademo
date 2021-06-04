package com.neu.lify.demo.mybatisplus.module.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neu.lify.demo.mybatisplus.common.model.Result;
import com.neu.lify.demo.mybatisplus.module.user.entity.User;
import com.neu.lify.demo.mybatisplus.module.user.model.UserQuery;
import com.neu.lify.demo.mybatisplus.module.user.model.UserResult;

import java.util.List;

public interface IUserService extends IService<User> {
    Result<String> addUser(User user);

    boolean updateUser(User user);

    void delUser(String id);

    void delLogicUser(String id);

    User getUserById(String id);

    List<User> selectUserByName(String name);

    List<User> getUsers();

    Result<List<User>> getAllUsers();

    IPage<UserResult> selectUserPage(UserQuery userQuery);

}
