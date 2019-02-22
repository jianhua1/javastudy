package com.jh.myfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//@SpringCloudApplication
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MyfgApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyfgApplication.class, args);
    }

}
