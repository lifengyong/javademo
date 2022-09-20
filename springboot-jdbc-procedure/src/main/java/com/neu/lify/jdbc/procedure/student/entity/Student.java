package com.neu.lify.jdbc.procedure.student.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {

    private Integer id;

    private String name;

    private Integer score;

    private Date updatetime;

}
