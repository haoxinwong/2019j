/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileTest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 测试File类的基本用法
 * @author WarSpite
 */
public class TestFile {
    public static void main(String[]args) throws IOException{
        
        //File f = new File("c:/a.txt");
        File f = new File("c:\\a.txt");
        System.out.println(f);
        f.renameTo(new File("c:\\b.txt"));
        
        System.out.println(System.getProperty("user.dir"));
        
        File f2 = new File("gg.txt");
        f2.createNewFile();
        
        System.out.println("File是否存在："+f2.exists());
        System.out.println("File是否是目录："+f2.isDirectory());
        System.out.println("File是否是文件："+f2.isFile());
        System.out.println("File最后修改时间："+new Date(f2.lastModified()));
        System.out.println("File的大小："+f2.length());
        System.out.println("File的文件名："+f2.getName());
        System.out.println("File的目录路径："+f2.getPath());
        
        File f3 = new File("c:/一");
        //boolean flag  = f3.mkdir();//目录结构中有一个不存在，则不会创造整个目录树
        boolean flag  = f3.mkdirs();//目录结构中有一个不存在也没关系，创建整个目录树
        System.out.println(flag);
        
    } 
    
}
