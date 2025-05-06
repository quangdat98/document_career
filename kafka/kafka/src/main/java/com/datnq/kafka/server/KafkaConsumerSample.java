package com.datnq.kafka.server;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "my-first-topic", groupId = "my-first-topic")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
