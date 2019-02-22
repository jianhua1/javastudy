package com.jh.myfg.myfeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "myzuul",fallback = MyFeignImpl.class)
public interface MyFeign {
    @RequestMapping(value = "/mycore2/getname",method = RequestMethod.GET)
    void invokeCore();
}
