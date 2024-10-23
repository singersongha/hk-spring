package com.example.command.kafka;

import com.example.command.entity.Product;
import com.example.command.kafka.dto.KafkaProductMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class KafkaProductProducer implements KafkaProductService{
    private final KafkaTemplate<String, KafkaProductMessage> kafkaTemplate;
    private static final String topic= "pro";

    @Override
    public void sell(Long productId) {

    }

    @Override
    public void save(Product product) {
        KafkaProductMessage message = new KafkaProductMessage
                (LocalDateTime.now(), product, "save");
        kafkaTemplate.send(topic, message);
    }

    @Override
    public void receive(Long productId) {
            Product product = new Product(productId, null, null, null);
            KafkaProductMessage message = new KafkaProductMessage(
                    LocalDateTime.now(), product, "receive");
        kafkaTemplate.send(topic, message);
    }
}
