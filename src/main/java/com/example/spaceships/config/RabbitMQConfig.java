package com.example.spaceships.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue spaceshipQueue() {
        return new Queue("spaceshipQueue", false);
    }
}
