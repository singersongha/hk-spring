package com.example.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PController {
//    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, Person> kafkaTemplate2;

    @PostMapping
    public void post(@RequestBody Person person) {
        kafkaTemplate2.send("test1", person);
    }

    //localhost:8080?msg="안녕"
//    @GetMapping
//    public void send(@RequestParam("msg") String msg) {
//        kafkaTemplate.send("tt-topic", msg);
//    }
//

}
