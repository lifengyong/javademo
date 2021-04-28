package com.neu.hikari.demo.modules.data.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.hikari.demo.modules.data.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {
}
