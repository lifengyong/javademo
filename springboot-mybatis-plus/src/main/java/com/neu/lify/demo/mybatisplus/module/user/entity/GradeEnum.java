package com.neu.lify.demo.mybatisplus.module.user.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.neu.lify.demo.mybatisplus.common.enums.IBaseEnum;

/**
 * 用户级别
 */
public enum GradeEnum implements IBaseEnum<Integer> {
    PRIMARY(1, "初级"),
    SECONDARY(2, "中级"),
    HIGH(3, "高级");

    GradeEnum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }

    @EnumValue
    private final int code;
    private final String descp;

    @Override
    public String getDescription() {
        return descp;
    }

    @Override
    public Integer getValue() {
        return code;
    }
}
