package com.lee.amqp.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lee
 * @date 2018/10/18
 */

@Component
@RabbitListener(queues = "topic.B")
public class TopicReceiverB {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Topic ReceiverB  : " + message);
    }
}
