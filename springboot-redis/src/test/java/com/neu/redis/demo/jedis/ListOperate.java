package com.neu.redis.demo.jedis;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.neu.redis.demo.common.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * 参考：" 尼恩 @ 疯狂创客圈"
 */
public class ListOperate {
    @Test
    public void operate() {
        Log log = LogFactory.get();
        Jedis jedis = JedisUtil.createJedis();

        log.info("ping: {}", jedis.ping());

        jedis.del("list1");
        jedis.rpush("list1", "yang01", "yang02", "zhang03", "yang05");

        log.info("type():{}", jedis.type("list1"));

        log.info("lrange(0, -1):{}", jedis.lrange("list1", 0, -1));
        log.info("lrange(1, 2):{}", jedis.lrange("list1", 1, 2));

        log.info("llen(list1):{}", jedis.llen("list1"));
        log.info("lindex(list1, 1):{}", jedis.lindex("list1", 1));

        //左、右侧弹出
        log.info("lpop(list1):{}", jedis.lpop("list1"));
        log.info("rpop(list1):{}", jedis.rpop("list1"));

        jedis.lset("list1", 0, "yang66");
        log.info("lrange(0, -1):{}", jedis.lrange("list1", 0, -1));

        jedis.close();
    }
}
