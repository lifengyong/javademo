package com.neu.lify.demo.mybatisplus.module.user.controller;

import com.neu.lify.demo.mybatisplus.common.model.Result;
import com.neu.lify.demo.mybatisplus.module.user.entity.User;
import com.neu.lify.demo.mybatisplus.module.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("add")
    public Result<String> addUser(@RequestBody User user) {
         return userService.addUser(user);
    }

    @GetMapping("getAll")
    public Result<List<User>> getAllUser() {
        Result<List<User>> result = userService.getAllUsers();
        return result;
    }
}
