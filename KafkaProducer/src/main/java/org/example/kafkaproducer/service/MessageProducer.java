package org.example.kafkaproducer.service;

import lombok.RequiredArgsConstructor;
import org.example.kafkaproducer.model.TestMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageProducer {
    private final KafkaTemplate<String, TestMessage> kafkaTemplate;

    public void sendMessage(String topic, TestMessage message) {
        kafkaTemplate.send(topic, message);
    }
}
