package com.neu.redis.demo.jedis;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.neu.redis.demo.common.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * 参考：" 尼恩 @ 疯狂创客圈"代码
 */
public class StringOperate {

    @Test
    public void operate() {
        Log log = LogFactory.get();
        Jedis jedis = JedisUtil.createJedis();

        log.info("ping: {}", jedis.ping());

        jedis.set("key0", "abcd");
        log.info("type(key0):{}", jedis.type("key0"));
        log.info("get(key0):{}", jedis.get("key0"));


    }
}
