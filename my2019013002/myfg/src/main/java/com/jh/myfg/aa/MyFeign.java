package com.jh.myfg.aa;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "myzuul")
public interface MyFeign {
    @RequestMapping(value = "/mycore/getusername",method = RequestMethod.GET)
    void getUserName();
}
