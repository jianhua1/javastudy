package com.jh.feigntest2.mycontroller;

import com.jh.feigntest2.feign.MyFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    MyFeign myFeign;
}
