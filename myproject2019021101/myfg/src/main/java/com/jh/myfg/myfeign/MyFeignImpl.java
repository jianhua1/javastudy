package com.jh.myfg.myfeign;

import org.springframework.stereotype.Component;

@Component
public class MyFeignImpl implements MyFeign{
    @Override
    public void invokeCore(){
        System.out.println("error123...");
    }
}
