package com.jh.mycore.mycore;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MyTest {

    public void ssa(int i,Log log){
        if(i==1){
            log.show("aa");
        }else {
            System.out.println("aaa");
        }
    }

    public void sst(Supplier<String> supplier){
        String str=supplier.get();
        System.out.println(str);
    }

    public void ssb(String str,Consumer<String> consumer){
        consumer.accept(str);
    }

    public void ssc(String[] str,Consumer<String> consumer1,Consumer<String> consumer2){
        for (String s : str) {
            consumer1.andThen(consumer2).accept(s);
        }
    }

    public String ssd(Integer ss, Function<Integer,String> function){
         return function.apply(ss);
    }

    public boolean sse(String a,Predicate<String> predicate){
        return predicate.test(a);
    }

    public boolean ssf(String a,Predicate<String> predicate1,Predicate<String> predicate2){
        return predicate1.or(predicate2).test(a);
    }

    public boolean ssg(String a,Predicate<String> predicate){
        return predicate.negate().test(a);
    }

    public static void main(String[] args) {
        MyTest myTest = new MyTest();
      /*  myTest.sst(()->{
            System.out.println("abd");
            return "abc";
        });*/
       /* myTest.ssa(2,(name)->
            System.out.println(name)
        );*/

       /* myTest.ssb("abcde",(a)->{
            System.out.println(a);
        });*/

      /* String[] str={"aa,man","bb,women","cc,man","dd,man"};
       myTest.ssc(str,(a)->{
           String[] name=a.split(",");
           System.out.print(name[0]);
       },(b)->{
           String[] name=b.split(",");
           System.out.println(name[1]);
       });*/

    /*  String ss=myTest.ssd(222323,(num)->{
          return "ab"+num;
      });*/

       /* boolean bol=myTest.ssf("abcdef",(str)->
        str.length()>15,(str1)->str1.contains("b"));*/
        boolean bol=myTest.ssg("abcd",(str)->{
           return str.length()<5;
        });

        System.out.println(bol);
    }
}
