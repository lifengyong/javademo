package com.neu.lify.demo.mybatisplus.module.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.lify.demo.mybatisplus.module.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {

}
