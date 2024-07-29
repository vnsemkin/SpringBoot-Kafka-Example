package org.example.kafkaconsumer.model;

import org.springframework.lang.NonNull;

public record KafkaTestModel(@NonNull String text) {
    public KafkaTestModel {
        if (isTextValid(text)) {
            throw new RuntimeException("Invalid test length");
        }
    }

    private boolean isTextValid(@NonNull String text) {
        return text.isEmpty() || text.length() > 50;
    }
}
