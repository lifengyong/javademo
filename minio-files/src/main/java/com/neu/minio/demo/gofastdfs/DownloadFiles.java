package com.neu.minio.demo.gofastdfs;

import cn.hutool.http.HttpUtil;


public class DownloadFiles {
    public static void main(String[] args) {
        //图片地址
        String url = "http://127.0.0.1:8080//group1/image/Q1w2e3.jpg";
        //文件地址
        String filepath = "D:/temp/123.jpg";
        //上传
        long filesize= HttpUtil.downloadFile(url, filepath);
        //输出结果
        System.out.println("filesize: " + filesize);
    }
}
