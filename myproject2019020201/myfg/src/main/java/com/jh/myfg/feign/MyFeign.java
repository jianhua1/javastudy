package com.jh.myfg.feign;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "myzuul3002")
public interface MyFeign {
    @RequestMapping(value = "/mycore3004/invokecore",method = RequestMethod.GET)
    void invokeCore();
}
