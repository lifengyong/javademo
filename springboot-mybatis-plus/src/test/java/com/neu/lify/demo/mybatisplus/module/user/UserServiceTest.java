package com.neu.lify.demo.mybatisplus.module.user;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neu.lify.demo.mybatisplus.module.user.entity.GradeEnum;
import com.neu.lify.demo.mybatisplus.module.user.entity.User;
import com.neu.lify.demo.mybatisplus.module.user.model.UserQuery;
import com.neu.lify.demo.mybatisplus.module.user.model.UserResult;
import com.neu.lify.demo.mybatisplus.module.user.service.IUserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    IUserService userService;

    @Test
    public void addUser() {
        User u = new User();
        u.setName("小羊");
        u.setPhone("1360009" + new Random().nextInt(10000));
        u.setScore(12.345f);
        u.setGrade(GradeEnum.PRIMARY);
        u.setCreateTime(LocalDateTime.now());

        userService.addUser(u);

        User after = userService.getById(u.getId());
        Assert.assertEquals(after.getName(), u.getName());
        Assert.assertSame(GradeEnum.PRIMARY, after.getGrade());
//        userService.removeById(u.getId());
    }

//    @Test
    public void getUserList() {
        List<User> list = userService.getUsers();
        if(list != null && list.size() > 0) {
            list.forEach(user -> {
                int status = user.getStatus();
                Assert.assertEquals(status, 0);
            });
        }
    }

//    @Test
    public void getUserPageVo() {
        UserQuery userQuery = new UserQuery();
        userQuery.setCurrentPage(1);
        userQuery.setPageSize(2);
        userQuery.setWorkTime(1);
        userQuery.setName("小羊");
        userQuery.setStartTime("2020-02-16 10:10:21");

        IPage<UserResult> result = userService.selectUserPage(userQuery);

//        Assert.assertEquals(result.getTotal(), 0);

    }

//    @Test
    public void delLogicUser() {
        String id = "3e3bd0b6e3186d5d6adb9da4e5dc50c9";
        userService.delLogicUser(id);
        User user = userService.getUserById(id);

        Assert.assertEquals(user, null);
    }

//    @Test
    public void getUserByName() {
        String name = "小羊";
        User u = new User();
        u.setName(name);
        u.setPhone("1360009" + new Random().nextInt(10000));
        u.setCreateTime(LocalDateTime.now());

        userService.addUser(u);

        List<User> list = userService.selectUserByName(name);
        Assert.assertTrue(list.size() > 0);

    }

//    @Test
    public void delUser() {
        String name = "小羊";
        User u = new User();
        u.setName(name);
        u.setPhone("1360009" + new Random().nextInt(10000));
        u.setCreateTime(LocalDateTime.now());

        userService.addUser(u);

        String id = u.getId();
        //物理删除
        userService.delUser(id);

        User delUser = userService.getUserById(id);
        Assert.assertNull(delUser);
    }


}
