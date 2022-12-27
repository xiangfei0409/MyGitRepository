package com.xiangfei.redis.config;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;
import java.net.UnknownHostException;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/27 12:17
 */
//不需要了，可以用StringRedisTemplate替代
@Configuration
public class RedisTemplateConfig {

    @Resource
    RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisTemplate<String, Object> redisTemplate() throws UnknownHostException {
        //创建Templete
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        //设置链接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //设置序列化工具
        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        //key和hashKey采用string学历噩耗
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        //value和hashValue采用JSON序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        return redisTemplate;
    }
}
