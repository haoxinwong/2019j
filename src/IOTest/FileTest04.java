/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest;

import java.io.File;

/**
 * 文件状态
 * 
 * @author WarSpite
 */
public class FileTest04 {
    public static void main(String[]args){
        File src = new File("2019Java\\gg.txt");
        
        System.out.println(src.getAbsolutePath());
        System.out.println("是否存在："+src.exists());
        System.out.println("是否文件："+src.isFile());
        System.out.println("是否文件夹："+src.isDirectory());
        
        System.out.println("----------------");
        src = new File("gg.txt");
        System.out.println("是否存在："+src.exists());
        System.out.println("是否文件："+src.isFile());
        System.out.println("是否文件夹："+src.isDirectory());
        
        System.out.println("----------------");
        src = new File("C:\\NetBeans\\2019Java");
        System.out.println("是否存在："+src.exists());
        System.out.println("是否文件："+src.isFile());
        System.out.println("是否文件夹："+src.isDirectory());
        
        //文件状态
        src =new File("xxx");
        if(!src.exists()){
            System.out.println("文件不存在");
        }else{
            if(src.isFile()){
                System.out.println("文件操作");
            }else{
                System.out.println("文件夹操作");
            }
        }
    }
    
}
