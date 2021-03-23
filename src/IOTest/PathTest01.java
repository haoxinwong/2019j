/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest;

import java.io.File;

/**
 * /\名称分隔符 separator
 * @author WarSpite
 */
public class PathTest01 {
    public static void main(String[]args){
        String path = "C:\\NetBeans\\2019Java\\gg.txt";
        System.out.println(File.separatorChar);
        
        //建议
        //1./
        path = "C:/NetBeans/2019Java/gg.txt";
        System.out.println(path);
        //2.常量拼接
        path = "C:"+File.separator+"NetBeans"+File.separator+"2019Java"+
                File.separator+"gg.txt";
        
        System.out.println(path);
        
    }
}
