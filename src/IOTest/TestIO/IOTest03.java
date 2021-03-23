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
 * 分段读取，文件字节输入流，
 * FileInputStream:通过字节的方式读取文件，适合读取所有类型的文件，
 * 全字符考虑FileReader
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author WarSpite
 */
public class IOTest03 {
    public static void main(String[]args){
        //1.创建源
        File src = new File("gg.txt");
        //2.选择流
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            //3.操作（读取）
            byte[]flush = new byte[1024];//缓冲容器
            int len = -1;//接受长度
            while((len = is.read(flush))!=-1){
                //字节数组-->字符串（解码）
                String str = new String(flush);
                System.out.println(str);
            }
            

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            try {
                //4.释放资源
                if(null!=is){
                   is.close(); 
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
