/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 使用try-catch处理异常
 * 比较完善的try catch
 * @author WarSpite
 */
public class Test02 {
    public static void main(String[]args){
        readMyFile();
    }
    public static void readMyFile(){
        FileReader reader = null;
        try {
            reader = new FileReader("c:/a.text");
            
            char c1 = (char)reader.read();//一定要关闭read()
            System.out.println(c1);
        } catch (FileNotFoundException e) {//子类在前，父类在后
            System.out.println("step1");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("step2");
            e.printStackTrace();
        } finally{
            System.out.println("step3");
            try {
                if(reader!=null){
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
