package com.ecommerce.ecommerce_event_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EcommerceEventProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceEventProducerApplication.class, args);
	}
}
