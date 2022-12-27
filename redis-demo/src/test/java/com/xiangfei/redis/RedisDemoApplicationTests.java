package com.xiangfei.redis;

import com.xiangfei.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class RedisDemoApplicationTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void testString() {
        //写入一个string数据
        redisTemplate.opsForValue().set("name", "任向飞");
        //查找一个string数据
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    void testSaveUser() {
        //写入数据
        redisTemplate.opsForValue().set("user:100", new User("向飞", 32));
        //获取数据
        User user  = (User) redisTemplate.opsForValue().get("user:100");
        System.out.println(user);
    }

}
