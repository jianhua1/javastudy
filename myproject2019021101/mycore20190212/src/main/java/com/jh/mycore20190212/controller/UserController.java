package com.jh.mycore20190212.controller;

import com.jh.mycore20190212.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    TUserService service;

    @RequestMapping("/getname")
    public void findAll(){
        System.out.println("12333aaaaaaaaaaaaaaaaaaa:"+Thread.currentThread().getName());
        service.findAll();
    }

}
