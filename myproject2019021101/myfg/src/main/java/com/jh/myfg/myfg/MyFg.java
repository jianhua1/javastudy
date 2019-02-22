package com.jh.myfg.myfg;

import com.jh.myfg.myfeign.MyFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFg {

    @Autowired
    MyFeign myFeign;

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    //@HystrixCommand
    public void showPage(){
        System.out.println("my fg..");
        myFeign.invokeCore();
    }

    @RequestMapping(value = "/show3",method = RequestMethod.GET)
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public void ss(){
        System.out.println("my 212fg..");
        myFeign.invokeCore();
    }
}
