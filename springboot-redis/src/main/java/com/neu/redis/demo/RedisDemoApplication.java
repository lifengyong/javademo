package com.neu.redis.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class RedisDemoApplication {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("",123);
        SpringApplication.run(RedisDemoApplication.class, args);
    }

}
