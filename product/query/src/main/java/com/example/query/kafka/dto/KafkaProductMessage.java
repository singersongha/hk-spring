package com.example.query.kafka.dto;

import com.example.query.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@RequiredArgsConstructor
public class KafkaProductMessage {
    private final LocalDateTime timestamp;
    private final Product message;
    private final String action;
}
