package com.jh.mycore20190212;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Mycore20190212Application {

	public static void main(String[] args) {
		SpringApplication.run(Mycore20190212Application.class, args);
	}

}

