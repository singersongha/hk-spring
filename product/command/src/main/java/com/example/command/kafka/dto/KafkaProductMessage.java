package com.example.command.kafka.dto;

import com.example.command.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@ToString
@RequiredArgsConstructor
public class KafkaProductMessage implements Serializable {
    private final LocalDateTime timestamp;
    private final Product message;
    private final String action;
}
