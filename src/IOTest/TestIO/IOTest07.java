/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.TestIO;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 字节数组输入流
 * 1.创建源：字节数组 不要太大
 * 2.选择流
 * 3.操作
 * 4.释放资源：可以不用处理
 * ByteArrayInputStream
 * @author WarSpite
 */
public class IOTest07 {
    public static void main(String[]args){
        
        //1.创建源
        byte[]src = "talk".getBytes();
        //2.选择流
        InputStream is = null;
        try{
            is = new ByteArrayInputStream(src);
            //3.操作
            byte[]flush = new byte[5];
            int len = -1;
            while((len=is.read(flush))!=-1){
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        }catch(IOException e){
            e.printStackTrace();
            
        }finally{
            //4.释放资源
            try{
                if(null!=is){
                    is.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
         
    }
}
