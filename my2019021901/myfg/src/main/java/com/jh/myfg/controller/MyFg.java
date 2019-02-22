package com.jh.myfg.controller;

import com.alibaba.fastjson.JSON;
import com.jh.myfg.config.YmlConfig;
import com.jh.myfg.feign.MyFeign;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
public class MyFg {
    @Autowired
    MyFeign myFeign;
    @Autowired
    YmlConfig ymlConfig;
    @Autowired
    SpringClientFactory springClientFactory;
    @Autowired
    AmqpTemplate amqpTemplate;

    /*@RequestMapping(name="/getuser1233")
    public void getUser(){
        System.out.println("==========34343======"+ymlConfig.getUploadDir());
        myFeign.getUser();
        //System.out.println("aaaa");
        //return "abc";
    }*/

    @PostMapping(value = "/myupload")
    public void myupload(MultipartFile file){
        try{
            System.out.println("------myupload"+file.getOriginalFilename());
            String uploadDir=ymlConfig.getUploadDir();
            File f=new File(uploadDir);
            if(!f.exists()){
                f.mkdirs();
            }
            File ff=new File(uploadDir+file.getOriginalFilename());
            file.transferTo(ff);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostMapping("/submitinfo")
    public void submitinfo(String username,@RequestParam(value = "fxk") List<String> fxk){
        try{
            System.out.println(username);
            System.out.println(JSON.toJSONString(fxk));
            String fxkStr=JSON.toJSONString(fxk);
            amqpTemplate.convertAndSend("ok_exchange","fruit",username+"==="+fxkStr);
            myFeign.submitinfo(username,fxk);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
