package com.xiangfei;

import com.xiangfei.jedis.util.JedisConnentionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/26 18:50
 */
public class test {
    private Jedis jedis;

    @BeforeEach
    void setUp(){
        //建立链接
//        jedis = new Jedis("127.0.0.1", 6379);
        jedis = JedisConnentionFactory.getJedis();
        //设置密码
//        jedis.auth("123456");
        //选择库
//        jedis.select(0);
    }

    @Test
    void testString(){
        //存入数据
        String result = jedis.set("name", "胡歌");
        System.out.println(result);
        //获取数据
        String name = jedis.get("name");
        System.out.println(name);
    }

    @Test
    void testHash(){
        //插入hash
        jedis.hset("user1", "name", "jack");
        jedis.hset("user1", "age", "21");
        Map<String, String> user1 = jedis.hgetAll("user1");
        System.out.println(user1);
    }

    @AfterEach
    void  tearDown(){
        if (jedis != null){
            jedis.close();
        }
    }
}
