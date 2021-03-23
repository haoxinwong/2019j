/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.TestBuffer;

import IOTest.TestIO.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 四个步骤：分段读取 文件字符输入流,加入缓冲流
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author WarSpite
 */
public class BufferTest03 {
    
    public static void main(String[]args){
        //1.创建源
        File src = new File("gg.txt");
        //2.选择流
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(src));
            //3.操作（分段读取）
            String line =null;
            while((line = reader.readLine())!=null){
                //字符数组-->字符串
                System.out.println(line);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            try {
                //4.释放资源
                if(null!=reader){
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
   
}
