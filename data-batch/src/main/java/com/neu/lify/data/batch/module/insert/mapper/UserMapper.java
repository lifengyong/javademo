package com.neu.lify.data.batch.module.insert.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.lify.data.batch.module.insert.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {
}
