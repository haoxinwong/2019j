/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest;

import java.io.File;

/**
 * 构建File对象
 * 相对路径和绝对路径
 * 1).存在盘符：绝对路径
 * 2).不存在盘符：相对路径，相对于当前工程
 * @author WarSpite
 */
public class FileTest02 {
    public static void main(String[]args){
        String path = "C:\\NetBeans\\2019Java\\gg.txt";
        
        //绝对路径
        File src = new File(path);
        System.out.println(src.getAbsolutePath());
        
        //相对路径
        System.out.println(System.getProperty("user.dir"));
        src = new File("gg.txt");
        System.out.println(src.getAbsolutePath());
        
        //构建一个不存在的文件
        src = new File("aaa/IO2.png");
        System.out.println(src.getAbsolutePath());

    }
}
