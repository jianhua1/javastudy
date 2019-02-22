package com.jh.mycore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyTest {
    public void aa(){
        ArrayList<User> list = new ArrayList<>();
        // List<OriFileLogicSelfCatalog> noDelSelObjTempList=oriFileLogicSelfCatalogList.stream().filter((OriFileLogicSelfCatalog obj)->obj.getFileLogicIsDeleted()==false).collect(Collectors.toList());
        List<User> tempList=list.stream().filter((User user)->user.isDeleted()==true).collect(Collectors.toList());
        List<String> temp2List=tempList.stream().map(User::getUsername).collect(Collectors.toList());
        System.out.println(temp2List.size());
        List ab=new ArrayList();
        ab.addAll(temp2List);
        System.out.println(ab.size());
        System.out.println(ab.toString());
    }
    public static void main(String[] args) {
       MyTest myTest=new MyTest();
       myTest.aa();
    }
}
