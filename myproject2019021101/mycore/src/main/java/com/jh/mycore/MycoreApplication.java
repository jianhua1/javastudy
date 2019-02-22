package com.jh.mycore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class MycoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycoreApplication.class, args);
    }

}

