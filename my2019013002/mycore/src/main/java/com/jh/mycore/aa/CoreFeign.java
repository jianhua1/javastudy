package com.jh.mycore.aa;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "myzuul")
public interface CoreFeign {
    @RequestMapping(value = "/getUserCore",method = RequestMethod.GET)
    void getUserCore();
}
