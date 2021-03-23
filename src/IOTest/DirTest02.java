/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest;

import java.io.File;

/**
 * 列出下一级
 * 1.list()：列出下级名称
 * 2.listFile()：列出下级File对象
 * 
 * 列出所有盘符 listRoots()
 * @author WarSpite
 */
public class DirTest02 {
    public static void main(String[]args){
        File dir = new File("C:\\NetBeans\\2019Java");
        
        
        //列出下级名称list
        String[] subNames = dir.list();
        for(String s:subNames){
            System.out.println(s);
        }
        
        //下级对象 listFiles()
        File[]subFiles = dir.listFiles();
        for(File s:subFiles){
            System.out.println(s.getAbsolutePath());
        }
        
        //所有盘符
        File[]roots = dir.listRoots();
        for(File s:roots){
            System.out.println(s.getAbsolutePath());
        }
    }
}
