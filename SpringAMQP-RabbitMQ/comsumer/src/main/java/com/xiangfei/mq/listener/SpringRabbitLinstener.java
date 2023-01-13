package com.xiangfei.mq.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Map;

/**
 * @Author: xiangfei
 * @CreateTime: 2023/1/13 16:21
 */
@Component
public class SpringRabbitLinstener {

//    @RabbitListener(queues = "simple.quene")
//    public void listenSimpleQuene(String msg) {
//        System.out.println("消费者接收到的simple.quene的消息是：【" + msg + "】");
//    }

    @RabbitListener(queues = "simple.quene")
    public void listenWoekQuene1(String msg) throws InterruptedException {
        System.out.println("消费者1接收到的simple.quene的消息是：【" + msg + "】" + LocalTime.now());
        Thread.sleep(20);
    }

    @RabbitListener(queues = "simple.quene")
    public void listenWoekQuene2(String msg) throws InterruptedException {
        System.err.println("消费者2.......接收到的simple.quene的消息是：【" + msg + "】" + LocalTime.now());
        Thread.sleep(200);
    }

    @RabbitListener(queues = "fanout.quene1")
    public void listenFanoutQuene1(String msg) {
        System.err.println("消费者接收到的fanout.quene1的消息是：【" + msg + "】" + LocalTime.now());
    }

    @RabbitListener(queues = "fanout.quene2")
    public void listenFanoutQuene2(String msg) {
        System.err.println("消费者接收到的fanout.quene2的消息是：【" + msg + "】" + LocalTime.now());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.quene1"),
            exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}
    ))
    public void listenDirectQuene1(String msg) {
        System.err.println("消费者接收到的direct.quene1的消息是：【" + msg + "】" + LocalTime.now());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.quene2"),
            exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "yellow"}
    ))
    public void listenDirectQuene2(String msg) {
        System.err.println("消费者接收到的direct.quene2的消息是：【" + msg + "】" + LocalTime.now());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.quene1"),
            exchange = @Exchange(name = "itcast.topic", type = ExchangeTypes.TOPIC),
            key = "china.#"
    ))
    public void listenTopicQuene1(String msg) {
        System.err.println("消费者接收到的direct.quene1的消息是：【" + msg + "】" + LocalTime.now());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.quene2"),
            exchange = @Exchange(name = "itcast.topic", type = ExchangeTypes.TOPIC),
            key = "#.news"
    ))
    public void listenTopicQuene2(String msg) {
        System.err.println("消费者接收到的direct.quene2的消息是：【" + msg + "】" + LocalTime.now());
    }

    @RabbitListener(queues = "object.quene")
    public void listenObjectQuene(Map<String, Object> msg) {
        System.out.println("消费者接收到的object.quene的消息是：【" + msg + "】");
    }
}
