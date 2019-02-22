package com.jh.myfg.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="myzuul2008")
public interface MyFeign {
    @RequestMapping(method = RequestMethod.GET,value = "/mycore8006/getuser")
    void getUser();

    @RequestMapping(method = RequestMethod.POST,value = "/mycore8006/submitinfo")
    void submitinfo(@RequestParam(value = "username") String username,@RequestParam(value = "fxk") List<String> fxk);
}
