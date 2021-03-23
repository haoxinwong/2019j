/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest;

import java.io.File;

/**
 * 打印子孙级目录和文件的名称
 * 
 * 
 * @author WarSpite
 */
public class DirTest03 {
    public static void main(String[]args){
        File src= new File("C:\\NetBeans");
        
        //创建目录
        count(src);
        System.out.println(LENGTH);
        
    }
    
    //打印子孙级目录和文件的名称
    public static void printName(File src,int deep){
        //控制层次
        for(int i = 0;i<deep;i++){
            System.out.print("-");
        }
        System.out.println(src.getName());
        if(null == src ||!src.exists()){
            return;
        }else if(src.isDirectory()){//目录
            for(File s:src.listFiles()){
                printName(s,deep+1);
            }
            
        }
    }
    
    //打印整个文件夹的字节
    private static long LENGTH = 0;
    public static void count(File src){
        
        //获取大小
        if(null!=src&&src.exists()){
            if(src.isFile()){
                LENGTH+=src.length();
            }else{
                for(File s:src.listFiles()){
                    count(s);
                }
            }
        }
    }
    
    
}
