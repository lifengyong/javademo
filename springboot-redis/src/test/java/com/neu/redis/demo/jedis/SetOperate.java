package com.neu.redis.demo.jedis;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.neu.redis.demo.common.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * 参考：" 尼恩 @ 疯狂创客圈"
 */
public class SetOperate {
    @Test
    public void operate() {
        Log log = LogFactory.get();
        Jedis jedis = JedisUtil.createJedis();

        log.info("ping: {}", jedis.ping());

        jedis.del("set1");

        jedis.sadd("set1", "yang01", "yang02", "yang03", "yang05");
        log.info("type():{}", jedis.type("set1"));

        log.info("smembers:{}", jedis.smembers("set1"));
        //集合元素个数
        log.info("scard():{}", jedis.scard("set1"));

        log.info("sismember(yang03):{}", jedis.sismember("set1", "yang03"));

        log.info("srem():{}", jedis.srem("set1", "yang01", "yang02"));
        log.info("smembers:{}", jedis.smembers("set1"));


        jedis.close();
    }
}
