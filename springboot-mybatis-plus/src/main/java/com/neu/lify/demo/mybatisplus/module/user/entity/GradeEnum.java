package com.neu.lify.demo.mybatisplus.module.user.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.neu.lify.demo.mybatisplus.common.enums.IBaseEnum;
import lombok.Getter;

/**
 * 用户级别
 */
@Getter
public enum GradeEnum implements IBaseEnum<Integer> {
    PRIMARY(1, "初级"),
    SECONDARY(2, "中级"),
    HIGH(3, "高级");

//    @JsonCreator
    GradeEnum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }

    @EnumValue //标记存储到数据库的值
    private final int code;
    @JsonValue //标记json返回的值,比如前端显示为：初级
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
