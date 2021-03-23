/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest;

import java.io.File;

/**
 * 
 * @author WarSpite
 */
public class FileTest01 {
    
    public static void main(String[]args){
        String path = "C:\\NetBeans\\2019Java\\gg.txt";
        
        //1.构建File对象
        File src = new File(path);
        System.out.println(src.length());
        
        //2.构建File对象
        src = new File("C:\\NetBeans\\2019Java","gg.txt");
        src = new File("C:\\NetBeans\\","2019Java\\gg.txt");
        System.out.println(src.length());
        
        //3.构建File对象
        src = new File(new File("C:\\NetBeans\\2019Java"),"gg.txt");
        System.out.println(src.length());
    }
    
}
