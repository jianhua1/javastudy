package com.jh.mycore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping(value = "/getcoreusername")
    public void getCoreUserName(){
        System.out.println("core:username");
    }

}
