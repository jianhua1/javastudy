package com.jh.myfg.amqp;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MqReceiver {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("ok_queue"),
            exchange = @Exchange("ok_exchange"),
            key="fruit"
    ))
    public void processMessage(String message){
        System.out.println("接收到的消息："+message);
    }
}
