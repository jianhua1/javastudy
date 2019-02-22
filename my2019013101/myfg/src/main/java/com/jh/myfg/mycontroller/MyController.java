package com.jh.myfg.mycontroller;

import com.jh.myfg.myfeign.MyFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    MyFeign myFeign;

    @GetMapping(value = "/invoke_core")
    public void invokeCore(){
        System.out.println("myfg:3000");
    }
}
