package com.jh.feigntest2.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "myzuul3002")
public interface MyFeign {
     @RequestMapping(value = "/mycore3004/invokecore",method = RequestMethod.GET)
     void getDept();
}
