package com.example.order_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.example.order_service.OrderServiceApplication.class, args);
	}

}
