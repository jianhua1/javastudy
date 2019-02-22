package com.jh.myfg.myfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "myzuul_ok")
public interface MyFeign {
     @RequestMapping(value = "",method = RequestMethod.GET)
    void invokeCore();
}
