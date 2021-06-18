package com.neu.websocket.demo.common.enums;


import lombok.Getter;

/**
 * 前端请求返回编码
 */
@Getter
public enum ResultCode {
  SUCCESS("1","请求处理成功"),
  ERROR("-1","请求处理失败");

  private String code;
  private String message;

  ResultCode(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
