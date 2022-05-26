package com.example.msaproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsaProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaProductApplication.class, args);
	}

}
