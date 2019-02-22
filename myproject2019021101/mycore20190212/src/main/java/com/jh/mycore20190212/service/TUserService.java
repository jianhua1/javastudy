package com.jh.mycore20190212.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.JSONReaderScanner;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.jh.mycore20190212.core.TUser;
import com.jh.mycore20190212.dao.TUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TUserService {
    @Autowired
    TUserDao tUserDao;
    @Autowired
    RedisTemplate redisTemplate;


    public void test1(){
        List<Integer> xxList=new ArrayList<>();
        List<TUser> list=new ArrayList<>();
        TUser tUser=new TUser();
        tUser.setUserAge(1);
        tUser.setUserId(1);
        tUser.setUserName("a");
        list.add(tUser);

        TUser tUser2=new TUser();
        tUser2.setUserAge(2);
        tUser2.setUserId(2);
        tUser2.setUserName("b");
        list.add(tUser2);
        File f=new File(".");


        List<Integer> noDelSelIdTempList=list.stream().map(TUser::getUserId).collect(Collectors.toList());
        System.out.println(noDelSelIdTempList.toString());
        //xxList.addAll(noDelSelIdTempList);
    }
    public static void main(String[] args) {
        TUserService t=new TUserService();
        t.test1();
    }

    public void findAll(){
        System.out.println("==============start================");
        List<String> list1=new ArrayList<String>();
        list1.add("a1");
        list1.add("a2");
        list1.add("a3");
        list1.add("a4");

        List<String> list2=new ArrayList<String>();
        list2.add("b1");
        list2.add("b2");
        list2.add("b3");
        list2.add("b4");

        List<String> list3=new ArrayList<String>();
        list3.add("b51");
        list3.add("b61");
        list3.add("b71");
        list3.add("b81");
        String xxx=JSON.toJSONString(list1);
        System.out.println(Thread.currentThread().getName());
        System.out.println(xxx);
        redisTemplate.opsForList().leftPush("listkey1", JSON.toJSONString(list1));
/*        redisTemplate.opsForList().rightPush("listkey2", JSON.toJSONString(list2));
        redisTemplate.opsForList().rightPush("listkey3", JSON.toJSONString(list3));*/
        // List<String> resultList1=(List<String>)redisTemplate.opsForList().leftPop("listkey1");
        // List<String> resultList2=(List<String>)redisTemplate.opsForList().rightPop("listkey2");
        // System.out.println("resultList1:"+resultList1);
        // System.out.println("resultList2:"+resultList2);



    /*    List<String> list1=new ArrayList<String>();
        list1.add("a1");
        list1.add("a2");
        list1.add("a3");

        List<String> list2=new ArrayList<String>();
        list2.add("b1");
        list2.add("b2");
        list2.add("b3");
        redisTemplate.opsForList().leftPush("listkey11",list1);
        redisTemplate.opsForList().rightPush("listkey21",list2);
        List<String> resultList1=(List<String>)redisTemplate.opsForList().leftPop("listkey11");
        List<String> resultList2=(List<String>)redisTemplate.opsForList().rightPop("listkey21");
        System.out.println("resultList11:"+resultList1);
        System.out.println("resultList21:"+resultList2);






        List<Object> strings = new ArrayList<Object>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        redisTemplate.opsForList().rightPushAll("listcollectionright223666", strings);
        System.out.println(redisTemplate.opsForList().range("listcollectionright223666",0,-1));

        redisTemplate.opsForList().rightPush("xpp1223555","xxxppp213555");

        List<TUser> list=null;
        list=redisTemplate.opsForList().range("achinaa12311123",0,-1);
        if(list.size()==0){
            list= tUserDao.findAllByUserId(123);
            redisTemplate.opsForList().leftPushAll("achinaa12311123",list);
        }
        for(int i=0;i<list.size();i++){
            TUser tUser=list.get(i);
            System.out.println(tUser.toString());
        }
*/
    }
}
