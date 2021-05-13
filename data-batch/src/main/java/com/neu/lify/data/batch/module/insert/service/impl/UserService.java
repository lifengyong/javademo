package com.neu.lify.data.batch.module.insert.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neu.lify.data.batch.common.util.UUIDGenerator;
import com.neu.lify.data.batch.module.insert.entity.User;
import com.neu.lify.data.batch.module.insert.mapper.UserMapper;
import com.neu.lify.data.batch.module.insert.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {

    ExecutorService pool = Executors.newFixedThreadPool(2);

    @Override
    public void addUser(User user) {
        super.save(user);
    }

    @Override
    public void addUserMore() {
        List<User> list = new ArrayList<>();
        for(int i = 0; i < 10000; i++) {
            list.add(createUser());
        }

        long start = System.currentTimeMillis();
        super.saveBatch(list, 200);

        long end = System.currentTimeMillis();

        long use = end - start;

        System.out.println("插入数据：" + list.size() + "条，用时" + use + "毫秒");

    }

    @Override
    public void addUserTenMillion() {

        List<List<User>> bigList = new ArrayList<>();
        System.out.println("创建开始时间：" + System.currentTimeMillis() + " 毫秒");
        for(int j = 0; j < 100; j++) {
            List<User> list = new ArrayList<>();
            for(int i = 0; i < 10000; i++) {
                list.add(createUser());
            }

            bigList.add(list);
        }
        System.out.println("创建结束时间：" + System.currentTimeMillis() + " 毫秒");

        long start = System.currentTimeMillis();
        for(int j = 0; j < bigList.size(); j++) {
            List<User> userList = bigList.get(j);
            long a = System.currentTimeMillis();

            pool.execute(() -> {
                super.saveBatch(userList, 200);
            });

            long b = System.currentTimeMillis();

            System.out.println("分批插入数据：" + userList.size() + "条，用时" + (b - a) + "毫秒");
        }
        long end = System.currentTimeMillis();



        long use = end - start;

        System.out.println("插入数据：" + bigList.size() * 10000 + "条，用时" + use + "毫秒");

    }

    private User createUser() {
        User user = new User();
        user.setId(UUIDGenerator.getUUID());
        user.setName("老牛2");
        user.setAddress("深圳经济技术开发区");
        user.setIdno("110221196002061258");
        user.setPhone("01087260269");
        user.setSex("m");
        user.setRemark("" + System.currentTimeMillis());
        user.setCreateTime(LocalDateTime.now());

        return user;
    }

}
