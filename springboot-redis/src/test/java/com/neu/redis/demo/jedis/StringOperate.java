package com.neu.redis.demo.jedis;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.neu.redis.demo.common.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * 参考：" 尼恩 @ 疯狂创客圈"
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
        log.info("exists(key0):{}", jedis.exists("key0"));
        log.info("strlen(key0):{}", jedis.strlen("key0"));
        //返回截取字符串, 范围 0,-1 表示截取全部
        log.info("getrange(key0):{}", jedis.getrange("key0", 0, -1));
        //范围 1,3 表示从表示区间[1,3]
        log.info("getrange(key0):{}", jedis.getrange("key0", 1, 3));

        log.info("append(key0):{}", jedis.append("key0", "hij"));
        log.info("get(key0):{}", jedis.get("key0"));

        log.info("rename(key0):{}", jedis.rename("key0", "key0-01"));
        log.info("exists(key0):{}", jedis.exists("key0"));

        jedis.mset("key1", "val01", "key2", "val02", "key3", "100");
        log.info("mget(key1,key2,key3):{}", jedis.mget("key1", "key2", "key3"));

        log.info("del(key1):{}", jedis.del("key1"));
        log.info("exists(key1):{}", jedis.exists("key1"));

        log.info("getSet(key2):{}", jedis.getSet("key2", "value12"));
        log.info("get(key2):{}", jedis.get("key2"));

        //自增1 要求数值类型
        log.info("incr(key3):{}", jedis.incr("key3"));
        log.info("incrBy(key3):{}", jedis.incrBy("key3", 20));
        log.info("incrByFloat(key3):{}", jedis.incrByFloat("key3", 2.60));

        //SETNX ：SET if Not Exists （如果不存在，则 SET)  key存在的情况下，不操作redis内存；也就是返回值是0
        log.info("setnx(key3):{}", jedis.setnx("key3", "value03"));
        log.info("get(key3):{}", jedis.get("key3"));

        //只有key都不存在的时候才设置
        log.info("mget(key2,key5):{}", jedis.mget("key2", "key5"));//[value12, null]
        log.info("mget(key6,key7):{}", jedis.mget("key6", "key7"));//[null, null]
        log.info("metnx(key2, key5):{}", jedis.msetnx("key2", "exists2", "key5", "exists5"));
        log.info("metnx(key6, key7):{}", jedis.msetnx("key6", "exists6", "key7", "exists7"));
        log.info("mget(key2,key5):{}", jedis.mget("key2", "key5"));//[value12, null]
        log.info("mget(key6,key7):{}", jedis.mget("key6", "key7"));//[exists6, exists7]

        //超时失效
        jedis.setex("key8", 2L, "2 second at");
        log.info("get(key8):{}", jedis.get("key8"));
        ThreadUtil.sleep(3000);
        log.info("get(key8):{}", jedis.get("key8"));

        //下标从0开始，从第三位开始,将新值覆盖旧值
        jedis.set("key9", "123456789");
        jedis.setrange("key9", 3, "abcdefg");
        log.info("get(key9):{}", jedis.get("key9"));

        log.info("keys(key*):{}", jedis.keys("key*"));

        jedis.close();
    }
}
