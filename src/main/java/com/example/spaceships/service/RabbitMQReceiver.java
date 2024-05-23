package com.example.spaceships.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQReceiver {

    @RabbitListener(queues = "spaceshipQueue")
    public void receive(String message) {
        System.out.println("Received message: " + message);
    }
}