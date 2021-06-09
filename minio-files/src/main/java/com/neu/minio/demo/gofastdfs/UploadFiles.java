package com.neu.minio.demo.gofastdfs;

import cn.hutool.http.HttpUtil;

import java.io.File;
import java.util.HashMap;

public class UploadFiles {
    public static void main(String[] args) {
        //文件地址
        File file = new File("D:\\picture\\V.jpg");
        //声明参数集合
        HashMap<String, Object> paramMap = new HashMap<>();
        //上传文件
        paramMap.put("file", file);
        //服务端文件名
        paramMap.put("filename", "Q1w2e3.jpg");
        //输出
        paramMap.put("output","json");
        //自定义路径
        paramMap.put("path","image");
        //场景
        paramMap.put("scene","picture");
        //上传
        String result= HttpUtil.post("http://127.0.0.1:8080/group1/upload", paramMap);
        //输出json结果
        System.out.println(result);
    }
}
