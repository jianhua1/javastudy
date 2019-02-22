package com.jh.myzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

// @SpringBootApplication
// @EnableZuulProxy
// @EnableEurekaClient

@SpringCloudApplication
@EnableZuulProxy
public class MyzuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyzuulApplication.class, args);
	}

}

