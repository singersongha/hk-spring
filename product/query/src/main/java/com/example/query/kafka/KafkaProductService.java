package com.example.query.kafka;

import com.example.query.entity.Product;

public interface KafkaProductService {
    void sell(Long productId);
    void save(Product product);
    void receive(Long productId);
}
