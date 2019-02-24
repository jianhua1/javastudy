package com.jh.mycore.mycontroller;

import com.alibaba.fastjson.JSON;
import com.jh.mycore.mycore.TUser;
import com.jh.mycore.myservice.TUserService;
import com.netflix.discovery.converters.Auto;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.List;

@RestController
public class TUserController {

    @Autowired
    TUserService tUserService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    AmqpTemplate amqpTemplate;


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


        // 这里可以提供更多地编码格式,另外由于部分编码格式是一致的所以会返回 第一个匹配的编码格式 GBK 和 GB2312
        public static final String[] encodes = new String[] { "UTF-8", "GBK", "GB2312", "ISO-8859-1", "ISO-8859-2" };

        /**
         * 获取字符串编码格式
         *
         * @param str
         * @return
         */
        public static String getEncode(String str) {
            byte[] data = str.getBytes();
            byte[] b = null;
            a:for (int i = 0; i < encodes.length; i++) {
                try {
                    b = str.getBytes(encodes[i]);
                    if (b.length!=data.length)
                        continue;
                    for (int j = 0; j < b.length; j++) {
                        if (b[j] != data[j]) {
                            continue a;
                        }
                    }
                    return encodes[i];
                } catch (UnsupportedEncodingException e) {
                    continue;
                }
            }
            return null;
        }

        /**
         * 将字符串转换成指定编码格式
         *
         * @param str
         * @param encode
         * @return
         */
        public static String transcoding(String str, String encode) {
            String df = "ISO-8859-1";
            try {
                String en = getEncode(str);
                if (en == null)
                    en = df;
                return new String(str.getBytes(en), encode);
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        }


        @RequestMapping(name = "/myupload",method = RequestMethod.POST)
    public void myupload(@RequestPart(value = "file") MultipartFile file){
        try{
            System.out.println(Charset.defaultCharset());
            System.setProperty("sun.jnu.encoding","utf-8");
            System.out.println("file.encoding:"+System.getProperty("file.encoding"));
            System.out.println("sun.jnu.encoding:"+System.getProperty("sun.jnu.encoding"));
            String fileName1=file.getOriginalFilename();
            System.out.println(fileName1);
            String[] str={"UTF-8","GBK","GB2312","ISO8859-1","ISO-8859-1","ASCII","UTF-16","US-ASCII","ASCII","GB18030","UNICODE","US-ASCII"};
            for(int i=0;i<str.length;i++){
                for(int j=0;j<str.length;j++){
                    String pp=new String(fileName1.getBytes(str[i]) ,str[j]);
                    System.out.println("由"+str[i]+"转为"+str[j]+": "+pp);
                }
                String dd=URLDecoder.decode(fileName1,str[i]);
                System.out.println("转为"+str[i]+": "+dd);
            }
            String uploadDir="f:/myupload/";
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
