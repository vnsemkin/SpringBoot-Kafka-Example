package org.example.kafkaproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic myTopic() {
        return new NewTopic("test-topic", 1, (short) 1);
    }
}

