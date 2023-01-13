package com.xiangfei.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xiangfei
 * @CreateTime: 2023/1/13 16:40
 */
@Configuration
public class FanoutConfig {
    //声明交换机itcast.fanout
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("itcast.fanout");
    }

    //fanout.quene1
    @Bean
    public Queue fanoutQuene1(){
        return new Queue("fanout.quene1");
    }

    //绑定队列1到交换机
    @Bean
    public Binding fanoutBanding1(Queue fanoutQuene1, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQuene1).to(fanoutExchange);
    }

    //fanout.quene2
    @Bean
    public Queue fanoutQuene2(){
        return new Queue("fanout.quene2");
    }

    //绑定队列2到交换机
    @Bean
    public Binding fanoutBanding2(Queue fanoutQuene2, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQuene2).to(fanoutExchange);
    }
}
