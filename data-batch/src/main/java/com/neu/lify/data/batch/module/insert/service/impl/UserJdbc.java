package com.neu.lify.data.batch.module.insert.service.impl;

import com.neu.lify.data.batch.common.util.UUIDGenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class UserJdbc extends Thread{
    public void run() {
        String url = "jdbc:mysql://localhost:3306/crash_course";
        String name = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "Yka@yunkouan.local";
        Connection conn = null;
        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, password);//获取连接
            conn.setAutoCommit(false);//关闭自动提交，不然conn.commit()运行到这句会报错
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 开始时间
        Long begin = new Date().getTime();
        //INSERT INTO ``.`` (`id`, `name`, `sex`, `phone`, `idno`, `address`, `remark`, `create_time`, `status`)
        //VALUES ('994b1d63c2004668b1857106928a3c5a', '老牛2', 'm', '01087260269', '110221196002061258', '深圳经济技术开发区', '1620872701113', '2021-05-13 10:25:01', '0');

        // sql前缀
        String prefix = "INSERT INTO user2 (`id`, `name`, `sex`, `phone`, `idno`, `address`, `remark`, `create_time`, `status`) VALUES ";
        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            PreparedStatement  pst = (PreparedStatement) conn.prepareStatement("select 1");//准备执行语句
            /*
              SQL语句过长，会提示如下错误，系统一般默认为4M
              Caused by: com.mysql.cj.jdbc.exceptions.PacketTooBigException: Packet for query is too large (15,800,110 > 4,194,304). You can change this value on the server by setting the 'max_allowed_packet' variable.
              查看大小：
              mysql> show variables like '%max_allowed_pack%';

              可以修改参数，100M如下(最多为1G)：
              mysql> set global max_allowed_packet = 100 * 1024 * 1024;
              另一种方式是修改my.ini配置文件，永久生效
             */
            int x = 1000;
            int y = 10000;
            // 外层循环，总提交事务次数
            for (int i = 1; i <= x; i++) {
                suffix = new StringBuffer();
                // 第j次提交步长
                for (int j = 1; j <= y; j++) {
                    // 构建SQL后缀
                    suffix.append("('" + UUIDGenerator.getUUID() +"','老牛2'"+ ",'m'"+",'01087260269'"+",'110221196002061258'"+",'深圳经济技术开发区'"+",'1620872701113'"+",'"+"2016-08-16 14:43:26"+"','0'" +"),");
                }
                // 构建完整SQL
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                // 添加执行SQL
                pst.addBatch(sql);
                // 执行操作
                pst.executeBatch();
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                suffix = new StringBuffer();

                System.out.println("新增数据提交次数：" + i);
            }

            pst.close();
            conn.close();

            // 结束时间
            Long end = new Date().getTime();
            // 耗时
            System.out.println(x*y + "条数据插入花费时间 : " + (end - begin) / 1000 + " s"+"  插入完成");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

