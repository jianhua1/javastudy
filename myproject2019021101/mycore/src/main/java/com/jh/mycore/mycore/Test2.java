package com.jh.mycore.mycore;

import java.util.Arrays;
import java.util.Comparator;

public class Test2 {
    public void s(){
        String[] s={"aa","abc","cccc","ee","d"};
        Arrays.sort(s,(o1,o2)->
            o2.length()-o1.length()
        );
        Arrays.stream(s).forEach((s1)->System.out.println(s1));
       /* Arrays.stream(s).forEach(()->{
            System.out.println("");
        });*/

       new Thread(()->System.out.println(Thread.currentThread().getName())).start();
       new Thread(()->System.out.println(Thread.currentThread().getName())).start();
    }
    public static void main(String[] args) {
        Test2 t=new Test2();
        t.s();
    }
}
