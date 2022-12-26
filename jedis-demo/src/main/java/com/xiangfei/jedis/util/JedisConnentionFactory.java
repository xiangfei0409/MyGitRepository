package com.xiangfei.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/26 19:04
 */
public class JedisConnentionFactory {
    private static final JedisPool jedisPool;

    static {
        //配置连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大链接
        jedisPoolConfig.setMaxTotal(8);
        //最大空闲连接
        jedisPoolConfig.setMaxIdle(8);
        //最小空闲连接
        jedisPoolConfig.setMinIdle(0);
        //设置等待最长时间，ms
        jedisPoolConfig.setMaxWaitMillis(1000);
        //创建连接池对象
        jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1", 6379,1000);
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
