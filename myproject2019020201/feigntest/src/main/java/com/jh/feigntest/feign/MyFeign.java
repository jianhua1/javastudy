package com.jh.feigntest.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
public interface MyFeign {
    public void getDept();
}
