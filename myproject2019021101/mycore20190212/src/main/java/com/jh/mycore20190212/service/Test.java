package com.jh.mycore20190212.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Supplier;

public class Test {

    public void startThread(Runnable runnable){
        new Thread(runnable).start();
    }

    public void show(MyFunctionalInterface myFunctionalInterface){
        myFunctionalInterface.method();
    }

    public void show2(int level,String message){
        if(level==1){
            System.out.println(level+"---"+message);
        }
    }

    public void show3(int level,MyFunctionalInterface myFunctionalInterface){
        if(level==1){
            System.out.println("exec...");
            myFunctionalInterface.method();
        }
    }

    public void show4(Supplier<String> supplier){
        System.out.println(supplier.get());
    }

    public void show5(Supplier<Integer> supplier){
        System.out.println(supplier.get());
    }

    public static void main(String[] args) {
       /* Test t=new Test();
        t.show(()->System.out.println("aaa21"));*/
       Test t=new Test();
       //t.show2(2,"hello,"+"ab");
        //t.show();
        t.show3(2,()->{
            System.out.println("不打印");
            return "hello,"+"ab";
        });

        new Thread(()->
            System.out.println(Thread.currentThread().getName())
        ).start();
        new Thread(()->
                System.out.println(Thread.currentThread().getName())
        ).start();
        String[] str={"ab","ccc","a"};

   /*     Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });*/
        Arrays.sort(str,(o1,o2)->
            o2.length()-o1.length()
        );
        System.out.println(Arrays.toString(str));
        System.out.println("+++++++++++++++++++++++++++++");
        t.show4(()->
            "abc22"
        );
        System.out.println("-------------------------------");
        int[] arr={1,-33,23,6,78};
        /*int temp=1;
        for (int obj : arr) {
            if(temp<obj){
               temp=obj;
            }
        }
        System.out.println(temp);*/


    }



}
