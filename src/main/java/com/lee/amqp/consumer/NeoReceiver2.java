package com.lee.amqp.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lee
 * @date 2018/10/18
 */
@Component
@RabbitListener(queues = "neo")
public class NeoReceiver2 {
  @RabbitHandler
  public void process(String neo) {
    System.out.println("Receiver 2: " + neo);
  }
}