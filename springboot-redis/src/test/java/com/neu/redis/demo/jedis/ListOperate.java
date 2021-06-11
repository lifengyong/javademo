package com.neu.redis.demo.jedis;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.neu.redis.demo.common.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * 参考：" 尼恩 @ 疯狂创客圈"代码
 */
public class ListOperate {
    @Test
    public void operate() {
        Log log = LogFactory.get();
        Jedis jedis = JedisUtil.createJedis();

        log.info("ping: {}", jedis.ping());

        jedis.del("list1");
        jedis.rpush("list1", "yang01", "yang02", "zhang03");



        jedis.close();
    }
}
