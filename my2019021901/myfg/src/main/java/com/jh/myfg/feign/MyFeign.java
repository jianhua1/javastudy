package com.jh.myfg.feign;

import com.jh.myfg.config.FeignMultipartSupportConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name="myzuul8008")
public interface MyFeign {
    @RequestMapping(method = RequestMethod.GET,value = "/mycore8006/getuser")
    void getUser();

    @RequestMapping(method = RequestMethod.POST,value = "/mycore8006/submitinfo")
    void submitinfo(@RequestParam(value = "username") String username,@RequestParam(value = "fxk") List<String> fxk);

    @RequestMapping(value = "/zuul/mycore8006/myupload",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    void myupload(@RequestPart("file") MultipartFile file);
}
