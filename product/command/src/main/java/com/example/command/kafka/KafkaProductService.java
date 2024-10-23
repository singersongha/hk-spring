package com.example.command.kafka;

import com.example.command.entity.Product;

public interface KafkaProductService {
    void sell(Long productId);
    void save(Product product);
    void receive(Long productId);
}
