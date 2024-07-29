package org.example.kafkaproducer.model;

import org.springframework.lang.NonNull;

public record TestMessage(@NonNull String text) {
    public TestMessage {
        if (isTextValid(text)) {
            throw new RuntimeException("Invalid test length");
        }
    }

    private boolean isTextValid(@NonNull String text) {
        return text.isEmpty() || text.length() > 50;
    }
}
