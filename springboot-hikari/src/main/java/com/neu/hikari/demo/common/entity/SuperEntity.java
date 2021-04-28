package com.neu.hikari.demo.common.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

@Data
public class SuperEntity<T extends Model> extends Model<T>{
    /**
     * 主键Id
     */
    private String id;

    @Override
    protected Serializable pkVal() {
        return id;
    }

}
