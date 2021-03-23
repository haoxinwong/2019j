/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.TestPrint;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 打印流PrintStream
 * @author WarSpite
 */
public class PrintTest01 {
    public static void main(String[] args) throws FileNotFoundException {
        //打印流System.out
        PrintStream ps = System.out;
        ps.println("打印流");
        ps.println(true);
        
        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")));
        ps.println("打印流");
        ps.println(true);
        ps.flush();
        ps.close();
        //重定向输出端,都打印进文件
        System.setOut(ps);
        System.out.println("change");
        
        //重定向回控制台
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
        System.out.println("我会回来的");
        
        
    }
}
