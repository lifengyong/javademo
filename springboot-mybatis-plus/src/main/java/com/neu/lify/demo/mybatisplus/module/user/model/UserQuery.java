package com.neu.lify.demo.mybatisplus.module.user.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserQuery {

	//当前页
    protected long currentPage;

	//每页显示条数
    protected long pageSize;

	//姓名
	private String name;

	//工作形式：全职、兼职
	private int workTime;

	//注册时间
	private String startTime;

}
