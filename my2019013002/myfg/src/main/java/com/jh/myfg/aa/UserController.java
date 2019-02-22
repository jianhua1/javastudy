package com.jh.myfg.aa;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/fg")
@Api(value = "usercontroller_fg")
public class UserController {

    @Autowired
    private MyFeign myFeign;
    @Autowired
    private MyService myService;

    @ApiOperation(value = "getUserName",httpMethod = "GET")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public void getUserName(){
        System.out.println("fg: aaaa");
        myFeign.getUserName();
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public void uploadFile(MultipartFile file){
        try{
            System.out.println("fg: upload...");
            String originalFileName=file.getOriginalFilename();
            System.out.println(originalFileName);
            byte[] bytes=file.getBytes();
            FileCopyUtils.copy(bytes,new File(file.getOriginalFilename()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
