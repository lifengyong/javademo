package com.neu.lify.data.batch.insert.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.lify.data.batch.insert.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {
}
