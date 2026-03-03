package com.lpu.springBootBasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;

@SpringBootApplication
public class SpringBootBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicsApplication.class, args);
	}

	@Bean
	public OpenAPI getOpenApi() {
		return new OpenAPI();
	}

}
