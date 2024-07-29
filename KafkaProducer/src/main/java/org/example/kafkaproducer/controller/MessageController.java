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

    @PostMapping
    public void sendMessage(@RequestBody TestMessage message) {
        String topic = "test-topic";
        producer.sendMessage(topic, message);
    }
}
