package com.xiangfei.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author: xiangfei
 * @CreateTime: 2023/1/12 16:26
 */
@SpringBootApplication
public class ComsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ComsumerApplication.class, args);
    }

    @Bean
    public Queue objectQueue(){
        return new Queue("simple.quene");
    }

//    @Bean
//    public MessageConverter messageConverter(){
//        return new Jackson2JsonMessageConverter();
//    }
}
