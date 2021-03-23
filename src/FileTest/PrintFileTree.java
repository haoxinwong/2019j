/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileTest;

import java.io.File;

/**
 * 使用递归算法打印目录树
 * @author WarSpite
 */
public class PrintFileTree {
    public static void main(String [] args){
        File f = new File("c:\\NetBeans");
        printFile(f,0);
    }
    
    static void printFile(File file,int level){
        int count = 0;
        //输出层数
        for(int i = 0;i<level;i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
        if(file.isDirectory()){
            File[]files = file.listFiles();
            
            for(File temp:files){
                count++;
                printFile(temp,level+1);
            }
        }
        System.out.println(count);
    }
}
