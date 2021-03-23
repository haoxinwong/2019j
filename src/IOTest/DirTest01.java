/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest;

import java.io.File;

/**
 * 创建目录
 * 1. mkdir():确保上级目录存在，不存在创建失败
 * 2. mkdirs():上级目录可以不存在，不存在一同来创建
 * @author WarSpite
 */
public class DirTest01 {
    public static void main(String[]args){
        File dir = new File("C:\\NetBeans\\2019Java\\test.txt");
        
        //创建目录 推荐使用mkdirs()
        boolean flag = dir.mkdirs();
        System.out.println(flag);
    }
}
