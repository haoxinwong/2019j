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
import java.io.PrintWriter;

/**
 * 打印流PrintWriter
 * @author WarSpite
 */
public class PrintTest02 {
    public static void main(String[] args) throws FileNotFoundException {
        
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("print.txt")));
        pw.println("打印流");
        pw.println(true);
        pw.flush();
        pw.close();
        
        
    }
}
