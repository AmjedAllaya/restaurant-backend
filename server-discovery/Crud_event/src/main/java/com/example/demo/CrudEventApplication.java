package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CrudEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudEventApplication.class, args);
	}

}
