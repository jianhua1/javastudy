package com.jh.mycore.myconfig;

import java.io.File;

public class Test {
    public void testFile(File f){
        try{
            if(f.exists()){
                if(f.isFile()){
                    f.delete();12
                }else {
                    File[] files=f.listFiles();
                    if(files.length==0){
                        files[0].delete();
                    }
                    for (File file : files) {
                        testFile(file);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test t=new Test();
        File f=new File("f:/xx3");
        t.testFile(f);
    }
}
