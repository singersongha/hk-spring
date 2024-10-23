package com.example.query.kafka;

import com.example.query.kafka.dto.KafkaProductMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductConsumer {
    private final KafkaProductService service;
    @KafkaListener(topics = "pro.SAVE")
    public void saveConsumer(KafkaProductMessage msg) {
        if(msg.getAction().equals("save"))
            service.save(msg.getMessage());
        if(msg.getAction().equals("sell"))
            service.sell(msg.getMessage().getId());
        if(msg.getAction().equals("receive"))
            service.receive(msg.getMessage().getId());
        // 성공하면 성공 토픽 {id}
        // 실패 id
        // aop transactional start
        // 성공 commit
        // 실패 rollback
    }

}
