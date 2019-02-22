package com.jh.myfg.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "myzuul01")
public interface MyFeign {
   @RequestMapping(value = "/mycore02/getcoreusername",method = RequestMethod.GET)
   void invokeFeign();
}
