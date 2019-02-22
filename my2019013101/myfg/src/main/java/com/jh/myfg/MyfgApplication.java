package com.jh.myfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MyfgApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfgApplication.class, args);
	}

}

