/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.TestIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 第一个程序：理解操作步骤
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author WarSpite
 */
public class IOTest02 {
    public static void main(String[]args){
        //1.创建源
        File src = new File("gg.txt");
        //2.选择流
        try {
            InputStream is = new FileInputStream(src);
            //3.操作（读取）
            int data1 = is.read();//第一个数据h
            int data2 = is.read();//第二个数据a
            int data3 = is.read();//第三个数据l
            int data4 = is.read();//如果没有得到数据，返回-1
            System.out.println((char)data1);
            System.out.println((char)data2);
            System.out.println((char)data3);
            System.out.println((char)data4);
            //4.释放资源
            is.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
