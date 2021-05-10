package com.neu.lify.demo.swagger.modules.user.service;

import com.neu.lify.demo.swagger.modules.user.model.User;
import com.neu.lify.demo.swagger.modules.user.model.UserPageResult;
import com.neu.lify.demo.swagger.modules.user.model.UserQueryModel;

public interface IUserService {
    /**
     * 创建新用户
     * @return
     */
    User createUser();

    /**
     * 分页查询
     * @param userQueryModel
     * @return
     */
    UserPageResult queryUserForPage(UserQueryModel userQueryModel);
}
