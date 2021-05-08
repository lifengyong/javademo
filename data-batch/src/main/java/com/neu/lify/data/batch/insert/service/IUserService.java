package com.neu.lify.data.batch.insert.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neu.lify.data.batch.insert.entity.User;

public interface IUserService extends IService<User> {
    void addUser(User user);
    void addUserMore();
}
