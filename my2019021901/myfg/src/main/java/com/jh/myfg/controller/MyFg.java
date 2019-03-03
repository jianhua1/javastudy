package com.jh.myfg.controller;

import com.alibaba.fastjson.JSON;
import com.jh.myfg.config.YmlConfig;
import com.jh.myfg.feign.MyFeign;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }

    @PostMapping(value = "/myupload")
    public void myupload(@RequestPart("file") MultipartFile file){
        try{
            //System.setProperty("sun.jnu.encoding","utf-8");
            System.out.println(file.getOriginalFilename());
            myFeign.myupload(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostMapping("/submitinfo")
    public void submitinfo(String username,@RequestParam(value = "fxk") List<String> fxk){
        try{
            System.out.println("mmmmmmmmkkkkkkkkkkklllllllll;;;;;;;;");
            System.out.println(username);
            System.out.println(JSON.toJSONString(fxk));
            String fxkStr=JSON.toJSONString(fxk);
           // amqpTemplate.convertAndSend("ok_exchange","fruit",username+"==="+fxkStr);
            myFeign.submitinfo(username,fxk);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
