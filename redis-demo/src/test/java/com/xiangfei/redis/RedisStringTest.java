package com.xiangfei.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiangfei.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/27 12:42
 */
@SpringBootTest
public class RedisStringTest {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testString() {
        //写入一个string数据
        stringRedisTemplate.opsForValue().set("name", "任向飞");
        //查找一个string数据
        Object name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    void testSaveUser() throws JsonProcessingException {
        User user = new User("任向飞", 32);
        //手动序列化
        String json = objectMapper.writeValueAsString(user);
        //写入数据
        stringRedisTemplate.opsForValue().set("user:200", json);
        //获取数据
        String str = stringRedisTemplate.opsForValue().get("user:200");
        //手动反序列化
        User user1 = objectMapper.readValue(str, User.class);
        System.out.println(user1);
    }

    @Test
    void testHash(){
        stringRedisTemplate.opsForHash().put("user:400","name","向飞");
        stringRedisTemplate.opsForHash().put("user:400","age","21");

        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:400");
        System.out.println(entries);
    }


}
