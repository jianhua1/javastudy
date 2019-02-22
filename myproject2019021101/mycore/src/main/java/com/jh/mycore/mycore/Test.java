package com.jh.mycore.mycore;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Test {
    public void show(){
        String separator=File.separator;
       try{
           //File f=new File("f:"+separator+"xx3"+separator+"yy3"+separator);
           File f=new File(".");
           System.out.println(f.exists());
           if(!f.exists()){f.mkdirs();}
           System.out.println(f.getCanonicalPath());
           System.out.println(f.getAbsolutePath());
           System.out.println(f.getPath());
           System.out.println(f.getParent());
           System.out.println(File.separator);
           System.out.println(File.pathSeparator);
           System.out.println("path:"+f.getCanonicalPath()+"abc.txt");
           File f1=new File(f.getCanonicalPath()+File.separator+"abc.txt");
           if(!f1.exists()){
               boolean bol=f1.createNewFile();
               System.out.println("create file:"+bol);
           }
           boolean bol2=f.delete();
           System.out.println("bol2:"+bol2);

           File file5=new File("f://mil");
           if(file5.exists()){
               File.createTempFile("abceaa",".txt",file5);
           }else{
               file5.mkdirs();
               File.createTempFile("abceaa",".txt",file5);
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public void isCanDeleted(String path){
        File f=new File(path);
        if(f.isFile()){
            f.delete();
        }else{
            File[] file=f.listFiles();
            for (File file1 : file) {
                isCanDeleted(file1.getPath());
            }
        }
        f.delete();
    }

    public static void main(String[] args) {
        Test t=new Test();
        t.show();
    }
}
