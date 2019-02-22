package com.jh.myfg.controller;

import com.jh.myfg.feign.MyFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MyController {

    @Autowired
    MyFeign myFeign;

    @RequestMapping(value = "/username",method = RequestMethod.GET)
    public void getUserName(){
        System.out.println("controller:----");
        myFeign.invokeFeign();
    }

    @RequestMapping(value = "/upload")
    public void upload(MultipartFile file){
        System.out.println("=============================:"+file.getOriginalFilename());
    }
}
