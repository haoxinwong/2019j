/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.TestBuffer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 分段读取，文件字节输入流，加入缓存流
 * FileInputStream:通过字节的方式读取文件，适合读取所有类型的文件，
 * 全字符考虑FileReader
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author WarSpite
 */
public class BufferTest01 {
    public static void main(String[]args){//后期修改后代码
        //1.创建源
        File src = new File("gg.txt");
        //2.选择流
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(src));
            //3.操作（读取）
            byte[]flush = new byte[1024];//缓冲容器
            //什么都没有的时候，编译器返回-1，所以接收长度是-1
            int len = -1;//接收长度
            while((len = is.read(flush))!=-1){
                //字节数组-->字符串（解码）
                String str = new String(flush,0,len);
                System.out.println(str);
            }
            //4.释放资源
            is.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            try{
                if(null!=is){
                    //由里关到外，先释放is的资源
                    is.close();
                }
            }catch(IOException e){
                e.printStackTrace();
                }
            }
            
    }
    //前期代码
    public static void test1(){
        //1.创建源
        File src = new File("gg.txt");
        //2.选择流
        InputStream is = null;
        BufferedInputStream bis = null;
        try {
            is = new FileInputStream(src);
            bis = new BufferedInputStream(is);
            //3.操作（读取）
            byte[]flush = new byte[1024];//缓冲容器
            //什么都没有的时候，编译器返回-1，所以接收长度是-1
            int len = -1;//接收长度
            while((len = is.read(flush))!=-1){
                //字节数组-->字符串（解码）
                String str = new String(flush,0,len);
                System.out.println(str);
            }
            //4.释放资源
            is.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            try{
                if(null!=is){
                    //由里关到外，先释放is的资源
                    is.close();
                }
            }catch(IOException e){
                e.printStackTrace();
                }
            }
            
            try{
                if(null!=bis){
                    //或者不用写is.close()也可以，因为bis里面已经有了
                    bis.close();
                }
            }catch(IOException e){
                e.printStackTrace();
                }
            }
    
}


    

