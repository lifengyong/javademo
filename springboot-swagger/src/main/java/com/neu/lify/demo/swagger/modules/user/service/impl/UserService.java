package com.neu.lify.demo.swagger.modules.user.service.impl;

import com.neu.lify.demo.swagger.modules.user.page.PageUtil;
import com.neu.lify.demo.swagger.modules.user.model.User;
import com.neu.lify.demo.swagger.modules.user.page.UserPageResult;
import com.neu.lify.demo.swagger.modules.user.model.UserQueryModel;
import com.neu.lify.demo.swagger.modules.user.service.IUserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Override
    public User createUser() {
        User u = new User();
        u.setName("老牛");
        u.setAddress("上海市张江经济技术开发区");
        u.setIdno("110221196002061256");
        u.setPhone("01087260266");
        u.setSex("m");
        u.setRemark("" + System.currentTimeMillis());
        u.setCreateTime(LocalDateTime.now());

        return u;
    }

    @Override
    public UserPageResult queryUserForPage(UserQueryModel userQueryModel) {
        UserPageResult result = new UserPageResult();
        PageUtil<User> page = new PageUtil<>();

        page.setCurrentPage(1);
        page.setPageSize(10);
        page.setTotalPage(20);
        page.setTotalCount(200);

        List<User> list = new ArrayList<>();
        list.add(createUser());list.add(createUser());list.add(createUser());list.add(createUser());list.add(createUser());
        list.add(createUser());list.add(createUser());list.add(createUser());list.add(createUser());list.add(createUser());

        page.setList(list);

        result.setResult(page);

        return result;
    }
}
