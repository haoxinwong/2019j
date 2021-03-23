/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 使用throws声明异常
 * @author WarSpite
 */
public class Test03 {
    public static void main(String[]args) throws IOException{
        readMyFile();
    }
    public static void readMyFile() throws IOException{
        FileReader reader = null;
        
        reader = new FileReader("c:/a.text");
        System.out.println("step01");
        char c1 = (char)reader.read();//一定要关闭read()
        System.out.println(c1);
        if(reader!=null){
            reader.close();
        }

    }
}
    


