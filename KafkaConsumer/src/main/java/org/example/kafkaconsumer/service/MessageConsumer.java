package org.example.kafkaconsumer.service;

import org.example.kafkaconsumer.model.KafkaTestModel;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    @KafkaListener(topics = "test-topic", groupId = "my-group") // Replace with your topic and group
    public void consume(KafkaTestModel message) {
        System.out.println("Received message: " + message);
    }
}
