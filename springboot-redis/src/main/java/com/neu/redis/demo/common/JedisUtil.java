package com.neu.redis.demo.common;

import redis.clients.jedis.Jedis;

public class JedisUtil {
    public static Jedis createJedis() {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.auth("wanghuan");
        return jedis;
    }
}
