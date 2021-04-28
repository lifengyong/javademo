package com.neu.hikari.demo.modules.dozer;

import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CopyData {

    @Autowired
    private Mapper dozerBeanMapper;

    public UserTarget CopyUser(UserSource us) {
        UserTarget ut = new UserTarget();
        dozerBeanMapper.map(us, ut);
        return ut;
    }
}
