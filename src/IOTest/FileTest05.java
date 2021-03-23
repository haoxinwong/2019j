/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest;

import java.io.File;
import java.io.IOException;

/**
 * 其他信息
 * length():文件的字节数
 * createNewFile() - 不存在才创建，存在
 * delete() - 删除已经存在的文件
 * 
 * @author WarSpite
 */
public class FileTest05 {
    public static void main(String[]args) throws IOException{
        File src = new File("C:\\NetBeans\\2019Java\\gg.txt");
        System.out.println("长度："+src.length());
        
        src = new File("C:\\NetBeans\\2019Java");
        System.out.println("长度："+src.length());
        
        src = new File("C:\\NetBeans\\2019Java\\io.txt");
        boolean flag = src.createNewFile();
        System.out.println(flag);
        
        flag  = src.delete();
        System.out.println(flag);
        
        //补充con com3 操作系统的设备名，不能正确创建
        src = new File("C:\\NetBeans\\2019Java\\con");
        src.createNewFile();

    }
}
