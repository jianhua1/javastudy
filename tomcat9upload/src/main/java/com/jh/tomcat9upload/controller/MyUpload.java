package com.jh.tomcat9upload.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MyUpload {
    @RequestMapping("/upload")
    public void upload(MultipartFile file){
        System.out.println("aa232a");
        System.out.println(file.getOriginalFilename());
    }
}
