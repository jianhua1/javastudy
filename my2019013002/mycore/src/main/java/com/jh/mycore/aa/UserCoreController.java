package com.jh.mycore.aa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCoreController {
    @GetMapping("/getusername")
   public void getUserCoreController(){
       System.out.println("core：my dep");
   }
}
