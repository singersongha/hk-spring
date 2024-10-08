package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Iterator;

@SpringBootApplication
public class DemoApplication {
	@Bean
	public String test() {
		return "test1";
	}

	@Bean
	public String test2() {
		return "test2";
	}

	@Bean
	public Student student() {
		return new Student();
	}
	public static void main(String[] args) {
		ConfigurableApplicationContext run  = SpringApplication.run(DemoApplication.class, args);
//		Iterator<String> beanNameIterator = run.getBeanFactory().getBeanNamesIterator();
//		while (beanNameIterator.hasNext()) {
//			String next = beanNameIterator.next();
//			System.out.println(next);
//		}
	}
}
