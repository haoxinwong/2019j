/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest;

import java.io.File;

/**
 * 名称或路径
 * getName():名称
 * getPath():返回相对或绝对
 * getAbsolutePath()：返回绝对
 * getParent()//上路径
 * 
 * @author WarSpite
 */
public class FileTest03 {
    
    public static void main(String[]args){
        File src = new File("C:\\NetBeans\\2019Java\\gg.txt");
        
        //基本信息
        System.out.println("名称："+src.getName());
        System.out.println("路径："+src.getPath());
        System.out.println("绝对路径："+src.getAbsolutePath());
        System.out.println("父路径"+src.getParent());
        
        src = new File("gg.txt");
        System.out.println("名称："+src.getName());
        System.out.println("路径："+src.getPath());
        System.out.println("绝对路径："+src.getAbsolutePath());
        System.out.println("父路径"+src.getParent());

        
        
        
    }
    
}
