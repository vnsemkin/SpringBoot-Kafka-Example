package org.example.kafkaproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kafkaproducer.model.TestMessage;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerMessageGenerator {
    private final MessageProducer producer;

    @EventListener(ApplicationReadyEvent.class)
    public void generateMessages() {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(1);
        try {
            log.info("Starting producer thread");
            es.scheduleAtFixedRate(() -> {
                log.info("Message was sent to Kafka");
                producer.sendMessage("test-topic",
                        new TestMessage("test-message : " + System.currentTimeMillis()));
            }, 0, 1, TimeUnit.SECONDS);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
        }

        // Add shutdown hook to close the es gracefully
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Shutting down ScheduledExecutorService");
            es.shutdown();
            try {
                if (!es.awaitTermination(5, TimeUnit.SECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        }));
    }
}