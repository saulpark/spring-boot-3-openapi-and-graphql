package com.template.springboot.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class SpringBootBackendApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendApiRestApplication.class, args);
	}
}
