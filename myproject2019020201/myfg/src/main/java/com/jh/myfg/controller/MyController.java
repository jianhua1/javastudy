package com.jh.myfg.controller;

import com.jh.myfg.feign.MyFeign;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
@EnableSwagger2
public class MyController {
    @Autowired
    MyFeign myFeign;
    @Autowired
    CustomProperties customProperties;

    @RequestMapping(value = "/invokefeign",method = RequestMethod.GET)
    public void invokeFeign(){
        System.out.println("mycontroller....");
        myFeign.invokeCore();
    }

    @RequestMapping(value = "/invokeupload",method = RequestMethod.POST)
    public void invokeUpload(@RequestParam("file") MultipartFile file){
        try{
            System.out.println("++++++++++++++++");
            System.out.println(file.getOriginalFilename()+"===="+file.getName());
            File file1 = new File(customProperties.getUploadPath(),file.getOriginalFilename());
            file.transferTo(file1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
