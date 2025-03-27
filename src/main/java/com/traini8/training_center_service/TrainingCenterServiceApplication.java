package com.traini8.training_center_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class TrainingCenterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingCenterServiceApplication.class, args);
	}

}
