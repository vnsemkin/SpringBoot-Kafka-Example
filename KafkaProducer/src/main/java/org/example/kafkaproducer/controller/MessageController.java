package org.example.kafkaproducer.controller;

import lombok.RequiredArgsConstructor;
import org.example.kafkaproducer.model.TestMessage;
import org.example.kafkaproducer.service.MessageProducer;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/send")
public class MessageController {
    public final MessageProducer producer;
    private final String topic = "test-topic";

    @PostMapping
    public void sendMessage(@RequestBody TestMessage message) {
        producer.sendMessage(topic, message);
    }
}
