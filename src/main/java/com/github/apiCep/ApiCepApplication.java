package com.github.apiCep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiCepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCepApplication.class, args);
	}

}
