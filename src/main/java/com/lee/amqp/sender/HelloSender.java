package com.lee.amqp.sender;

/**
 * @author lee
 * @date 2018/10/18
 */

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * producter-->queue-->consumer 模式
     */
    @GetMapping("/hello")
    public void send() {
        String context = "hello " + LocalDateTime.now();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }

    /**
     * 竞争模式
     */
    @GetMapping("/neo")
    public void neo() {
        for (int i=0;i<1000;i++){
            String context = "spirng boot neo queue"+" ****** "+i;
            System.out.println("Sender1 : " + context);
            this.rabbitTemplate.convertAndSend("neo", context);
        }
    }

    /**
     * 发布/订阅模式
     */
    @GetMapping("/fanout")
    public void fanout() {
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }

    @GetMapping("/topic")
    public void topic() {
        String context = "hi, i am message all";
        System.out.println("topic1 Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", context);
    }

    @GetMapping("/topicA")
    public void topicA() {
        String context = "hi, i am message A";
        System.out.println("topicA Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messageA", context);
    }

    @GetMapping("/topicB")
    public void topicB() {
        String context = "hi, i am messages B";
        System.out.println("topicB Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messageB", context);
    }
}
