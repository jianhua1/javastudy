package com.jh.myproject2019021501.controller;

import com.alibaba.fastjson.JSON;
import com.jh.myproject2019021501.dao.TUser;
import com.jh.myproject2019021501.service.UserService;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class MyController {
    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    MyProps myProps;

    @RequestMapping(name = "getuser")
    public void getUser(){
        System.out.println(myProps.getPath());
      /*  TUser tUser=userService.getUser();
        List<TUser> list=new ArrayList<>();
        list.add(tUser);
        //redisTemplate.opsForList().leftPushAll(tUser.getUserId(),list);
        String str=JSON.toJSONString(list);
        List<TUser> list2=new ArrayList<>();
        list2.add(tUser);*/
       /* redisTemplate.opsForValue().set("a",str);
        System.out.println(str);*/
       //redisTemplate.opsForList().leftPushAll("c",JSON.toJSONString(list2));
        //redisTemplate.opsForValue().set("d",JSON.toJSONString(tUser));
       // stringRedisTemplate.opsForValue().set("e",JSON.toJSONString(tUser));
        //stringRedisTemplate.opsForValue().set("f",JSON.toJSONString(list2));
    /*    Set<String> set=new HashSet<>();
        set.add("a");
        set.add("c");
        set.add("b");
        set.add("a");
        System.out.println(set.toString());
        stringRedisTemplate.opsForZSet().add("a9","a",0.1);*/
      // redisTemplate.opsForValue().set("o",list2.toString());
    }
}
