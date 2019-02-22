package com.jh.mycore.mycontroller;

import com.alibaba.fastjson.JSON;
import com.jh.mycore.mycore.TUser;
import com.jh.mycore.myservice.TUserService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TUserController {

    @Autowired
    TUserService tUserService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    AmqpTemplate amqpTemplate;
    @RequestMapping(name = "/getuser")
    public void findAllByUserAge() {
        try {
            Integer userAge=21;
            String userStr=null;
            System.out.println("==========="+redisTemplate.opsForValue().get("xxaaua"));
            if(redisTemplate.opsForValue().get("xxaaua")==null){
                List<TUser> list=tUserService.findAllByUserAge(userAge);
                userStr=JSON.toJSONString(list);
                for (TUser tUser : list) {
                    System.out.println(tUser.toString());
                }
                redisTemplate.opsForValue().set("xxaaua",userStr);
            }else{
                userStr=(String)redisTemplate.opsForValue().get("xxaaua");
            }
            System.out.println("=================="+userStr);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/submitinfo",method = RequestMethod.POST)
    public void submitinfo(@RequestParam(value = "username") String username,@RequestParam(value = "fxk") List<String> fxk){
        System.out.println("mm:"+username+fxk.size());


    }
}
