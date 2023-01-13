package com.xiangfei.mq.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: xiangfei
 * @CreateTime: 2023/1/12 16:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage2SimpleMessage() {
        String queneName = "simple.quene";
        String message = "hello, spring amqp!";
        rabbitTemplate.convertAndSend(queneName, message);
    }

    @Test
    public void testSendMessage2WorkMessage() throws InterruptedException {
        String queneName = "simple.quene";
        String message = "hello, message__";
        for (int i = 1; i <= 50; i++) {
            rabbitTemplate.convertAndSend(queneName, message + i);
            Thread.sleep(20);
        }
    }

    @Test
    public void testSendFanoutExchange(){
        String exchangeName = "itcast.fanout";
        String message = "hell everyone";
        rabbitTemplate.convertAndSend(exchangeName, "", message);
    }

    @Test
    public void testSendDirectExchange(){
        String exchangeName = "itcast.direct";
        String message = "hell red";
        rabbitTemplate.convertAndSend(exchangeName, "red", message);
    }

    @Test
    public void testSendTopicExchange(){
        String exchangeName = "itcast.topic";
        String message = "任向飞，你好！心情很好";
        rabbitTemplate.convertAndSend(exchangeName, "china.weather", message);
    }
}
