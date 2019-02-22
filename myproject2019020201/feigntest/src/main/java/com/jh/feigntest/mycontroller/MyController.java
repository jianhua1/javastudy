package com.jh.feigntest.mycontroller;

import com.jh.feigntest.feign.MyFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    MyFeign myFeign;
}
