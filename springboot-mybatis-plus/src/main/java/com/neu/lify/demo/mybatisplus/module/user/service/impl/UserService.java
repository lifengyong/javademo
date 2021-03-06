package com.neu.lify.demo.mybatisplus.module.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neu.lify.demo.mybatisplus.common.model.Result;
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
    public Result<String> addUser(User user) {
        save(user);
        return Result.success();
    }

    @Override
    public boolean updateUser(User user) {
        try{
            boolean result = updateById(user);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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

    @Override
    public Result<List<User>> getAllUsers() {
        List<User> list = getUsers();
        return Result.of(list);
    }

    public IPage<UserResult> selectUserPage(UserQuery userQuery) {
        Page<UserResult> page = new Page<>(userQuery.getCurrentPage(), userQuery.getPageSize());
        // ????????? count sql ??????????????? MP ?????????????????? SQL ??????????????????????????????????????? count ??????
        // page.setOptimizeCountSql(false);
        // ??? total ????????? 0 ???????????? setSearchCount(false) ???????????????????????? count ??????
        // ??????!! ???????????????????????????????????????????????????
        IPage<UserResult> listUser = userMapper.selectPageVo(page, userQuery);

        return listUser;
    }

}
