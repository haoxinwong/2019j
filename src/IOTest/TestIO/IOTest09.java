/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.TestIO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
 * 1.图片读取到字节数组中
 * 2.字节数组写出到文件
 * @author WarSpite
 */
public class IOTest09 {
    public static void main(String[]args){
        //图片转成字节数组
        byte[]datas = fileToByteArray("gg.txt");
        System.out.println(datas.length);
        
        byteArrayToFile(datas,"gg.txt");
    }
    
    /**
     * 1.图片读取到字节数组
     * 图片到程序FileInputStream
     * 程序到字节数组ByteArrayOutputStream
     */
    public static byte[] fileToByteArray(String filePath){
        //1.创建源与目的地
        File src = new File(filePath);
        byte[] dest = null;
        //2.选择流
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        
        try {
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();
            //3.操作
            byte[]flush = new byte[1024*10];//缓冲容器
            int len = -1;
            while((len=is.read(flush))!=-1){
                baos.write(flush,0,len);//写出到字节数组中
                
            }
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            try{
                if(null!=is){
                    is.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    
    /**
     * 2.字节数组写出到图片
     * 字节数组到程序ByteArrayOutputStream
     * 程序到文件FileOutputStream
     * 
     */
    public static void byteArrayToFile(byte[]src,String filePath){
        //1.创建源
        File dest = new File(filePath);//目的地
        //选择流
        InputStream is = null;
        OutputStream os = null;
        
        try{
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest,true);
            //3.操作
            byte[]flush = new byte[5];//缓冲容器
            int len = -1;//接受长度
            while((len = is.read(flush))!=-1){
                os.write(flush,0,len);
            }
            os.flush();
        }catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            //4.释放资源
            try{
                if(null!=os){
                    os.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
             
        }
}

