package com.neu.lify.demo.mybatisplus.module.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neu.lify.demo.mybatisplus.module.user.entity.User;
import com.neu.lify.demo.mybatisplus.module.user.mapper.UserMapper;
import com.neu.lify.demo.mybatisplus.module.user.model.UserQuery;
import com.neu.lify.demo.mybatisplus.module.user.model.UserResult;
import com.neu.lify.demo.mybatisplus.module.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        save(user);
    }

    @Override
    public void delUser(String id) {
        userMapper.delUser(id);
    }

    @Override
    public void delLogicUser(String id) {
        removeById(id);
    }

    @Override
    public User getUserById(String id) {
        return getById(id);
    }

    @Override
    public List<User> selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    @Override
    public List<User> getUsers() {
        return super.list();
    }

    public IPage<UserResult> selectUserPage(UserQuery userQuery) {
        Page<UserResult> page = new Page<>(userQuery.getCurrentPage(), userQuery.getPageSize());
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        IPage<UserResult> listUser = userMapper.selectPageVo(page, userQuery);

        return listUser;
    }

}
