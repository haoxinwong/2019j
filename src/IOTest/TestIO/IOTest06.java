/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.TestIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 文件字符输出流
 * @author WarSpite
 */
public class IOTest06 {
    public static void main(String[]args) {
        //1.创建源
        File dest = new File("io.txt");
        //2.选择流
        Writer writer = null;
        
        try {
            writer = new FileWriter(dest,true);
            String msg = "hao";
            //3.操作（写出）
            //写法一
            //char[]datas = msg.toCharArray();//字符串-->字符数组
            //writer.write(datas,0,datas.length);
            //writer.flush();
            //写法二
            //writer.write(msg);
            //writer.flush();
            
            //写法三
            writer.append(msg).append(msg);
            writer.flush();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            if(null!= writer){
                try {
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
