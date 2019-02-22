package com.jh.mycore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping(value = "/invokecore",method = RequestMethod.GET)
    public void core(){
        System.out.println("core...");
    }
}
