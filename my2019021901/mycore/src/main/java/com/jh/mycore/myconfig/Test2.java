package com.jh.mycore.myconfig;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class Test2 {
    public void getAb(){
        try{
            List<String> list=Arrays.asList(new String[]{"hello","abc"});
            Class<?> cls=list.getClass();
            for(Field field:cls.getDeclaredFields()){
               // field.setAccessible(true);
                System.out.println(field.getName()+"======="+field.get(list));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        Test2 t=new Test2();
        t.getAb();
    }
}
