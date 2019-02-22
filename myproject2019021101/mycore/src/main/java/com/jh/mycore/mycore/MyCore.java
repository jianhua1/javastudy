package com.jh.mycore.mycore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCore {

    @RequestMapping(value = "/getname",method = RequestMethod.GET)
    public void getName(){
        System.out.println("...name");
    }
}
