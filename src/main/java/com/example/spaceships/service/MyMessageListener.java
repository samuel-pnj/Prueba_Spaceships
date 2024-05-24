package com.example.spaceships.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class MyMessageListener implements MessageListener<String, String> {

    @Override
    public void onMessage(ConsumerRecord<String, String> record) {
        // Procesa el mensaje recibido
        String value = new String(record.value());
        System.out.println("Mensaje recibido: " + value);
    }
}
