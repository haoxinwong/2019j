/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.TestIO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 分装拷贝
 * 分装释放资源
 * @author WarSpite
 */
public class FileUtils2 {
    public static void main(String[]args){
        try {
            //文件到文件
            InputStream is = new FileInputStream("gg.txt");
            OutputStream os = new FileOutputStream("io.txt");
            copy(is,os);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        byte[]datas = null;
        //文件到字节数组
        try {
            //文件到文件
            InputStream is = new FileInputStream("gg.png");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            copy(is,os);
            datas = os.toByteArray();
            System.out.println(datas.length);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        //字节数组到文件
        try {
            //文件到文件
            ByteArrayInputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("gg.png");
            copy(is,os);

            System.out.println(datas.length);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * 对接输入输出流
     * try...with...resource
     * @param is
     * @param os 
     */
    public static void copy(InputStream is, OutputStream os){
        //try(is;os){
        try{
            //3.操作（分段读取）
            byte[]flush = new byte[1024];//缓冲容器
            int len = -1;//接受长度
            while((len = is.read(flush))!=-1){
                //字节数组-->字符串（解码）
                os.write(flush,0,len);
            }
            os.flush();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        
        }
    }
}
    
    
    

