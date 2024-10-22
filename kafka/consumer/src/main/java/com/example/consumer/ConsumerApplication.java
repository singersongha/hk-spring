package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;


@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
	@KafkaListener(topics = "test1", id = "con")
	public void consume(Person person){
		System.out.println(person);
	}

	@Bean
	public RecordMessageConverter converter() {
		return new JsonMessageConverter();
	}


//	@RetryableTopic(attempts = "5", backoff = @Backoff(delay = 3000, maxDelay = 10000, multiplier = 2))
//	@KafkaListener(topics = "tt-topic", id="songha")
//	public void consumer(String msg){
//		System.out.println(msg);
//		throw new RuntimeException(); // 성공할 때까지 계속 에러 보냄
//	}
//	@DltHandler
//	public void dlt(String msg, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
//		System.out.println("dlt : " + topic + " : " + msg);
//	}
}

