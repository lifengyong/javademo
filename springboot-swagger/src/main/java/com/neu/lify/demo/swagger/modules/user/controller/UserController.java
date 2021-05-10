package com.neu.lify.demo.swagger.modules.user.controller;

import com.neu.lify.demo.swagger.modules.user.model.User;
import com.neu.lify.demo.swagger.modules.user.model.UserPageResult;
import com.neu.lify.demo.swagger.modules.user.model.UserQueryModel;
import com.neu.lify.demo.swagger.modules.user.service.IUserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@Api(tags = "用户操作接口")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/addUser")
    @ResponseBody
    @ApiOperation(value = "增加用户", httpMethod = "POST")
    public String addUser(@ApiParam(value = "增加用户信息") @RequestBody User user) {

        return "ok";
    }

    @GetMapping("/queryUserById")
    @ResponseBody
    @ApiOperation(value = "根据Id获取用户信息", httpMethod = "GET")
    @ApiImplicitParam(paramType = "query", dataType = "int", name = "id", value = "用户ID", required = true) //数字类型，用int
    public User queryUserById(int id){

        log.info("id:{}", id);
        return null;
    }

    @PostMapping("/queryUserByAge")
    @ResponseBody
    @ApiOperation(value = "根据年龄获取用户信息", httpMethod = "POST")
    public User queryUserByAge(@ApiParam(value="年龄", required = true) int age){

        log.info("age: {}", age);
        return null;
    }

    @GetMapping("/queryUserByIdno")
    @ResponseBody
    @ApiOperation(value = "根据身份证号获取用户信息", httpMethod = "GET")
    @ApiImplicitParam(paramType = "query", dataType = "String", name = "idno", value = "身份证号", required = true)
    public User queryLastAttence(String idno) {
        User u = userService.createUser();
        return u;
    }

    @GetMapping("/queryUserList")
    @ResponseBody
    @ApiOperation(value = "获取多个用户信息", httpMethod = "GET")
    public List<User> queryUserList() {
        List list = new ArrayList();
        list.add(userService.createUser());
        list.add(userService.createUser());
        list.add(userService.createUser());

        return list;
    }

    @PostMapping("/queryUserForPage")
    @ResponseBody
    @ApiOperation(value = "分页获取用户信息", httpMethod = "POST")
    public UserPageResult queryUserForPage(@RequestBody UserQueryModel userQueryModel) {

        return userService.queryUserForPage(userQueryModel);
    }

    @GetMapping("/queryUserByNameAndPhone")
    @ResponseBody
    @ApiOperation(value = "根据用户名和手机号获取用户信息", httpMethod = "GET")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "String", name = "name", value = "用户名", required = true),
                         @ApiImplicitParam(paramType = "query", dataType = "String", name = "phone", value = "手机号")})
    public User queryUserByIdno(String name, String phone) {
        User u = userService.createUser();
        return u;
    }

    /**
     * 字符串方式传参
     */
    @PostMapping("/setUserLotteryInfo")
    @ApiOperation(value = "用户购买彩票订单", httpMethod = "POST")
    public String setUserLotteryInfo(@ApiParam(value="批量订单号，String数组传输") @RequestParam(value = "noList", required = true) List<String> noList,
                                     @ApiParam(value="订单状态(1:待处理 2:出票中 3:完成 4:关闭)") @RequestParam(value = "status", required = true) int status) {
        if(noList != null) {
            for(String no : noList) {
                log.info(no);
            }
        }

        log.info("status: {}", status);

        return "ok";
    }
}
