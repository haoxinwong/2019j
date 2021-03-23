/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.TestConvert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 转换流：InputStreamReader&OutputStreamWriter
 * 1.以字符流的形式操作字节流（纯文本）
 * 2.指定字符集
 * @author WarSpite
 */
public class ConvertTest02 {
    public static void main(String[]args){
        test04();
        
                
    }
    
    //爬取为文件
    public static void test04(){
        //操作System.in和System.out
        //InputStreamReader isr = new InputStreamReader(System.in);
        //OutputStreamWriter osw = new OutputStreamWriter(System.out);
        //增加缓冲
        //操作网络流 下载百度的源代码
        try(BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                new URL("http://www.baidu.com").openStream(),"UTF-8"));
                BufferedWriter writer =
                new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream("baidu.html"),"UTF-8"));){
            //操作读取
            String msg;
            while((msg = reader.readLine())!=null){
                //不输出，直接存为文件
                //System.out.print(msg);
                 writer.write(msg);
                 writer.newLine();
            }
            writer.flush();
                   
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
                
    }
    
    //解决
    public static void test03(String[]args){
        //操作System.in和System.out
        //InputStreamReader isr = new InputStreamReader(System.in);
        //OutputStreamWriter osw = new OutputStreamWriter(System.out);
        //增加缓冲
        //操作网络流 下载百度的源代码
        try(BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                new URL("http://www.baidu.com").openStream(),"UTF-8"));){
            //操作读取
            String msg;
            while((msg = reader.readLine())!=null){
                System.out.print(msg);
            }
                   
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
                
    }
    
    //解决乱码，但不是最优解
    public static void test02(String[]args){
        //操作System.in和System.out
        //InputStreamReader isr = new InputStreamReader(System.in);
        //OutputStreamWriter osw = new OutputStreamWriter(System.out);
        //增加缓冲
        //操作网络流 下载百度的源代码
        try(InputStreamReader is =
                new InputStreamReader( new URL("http://www.baidu.com").openStream(),"UTF8");){
            //操作读取
            int temp;
            while((temp = is.read())!=-1){
                System.out.print((char)temp);
            }
                   
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
                
    }
    
    
    //出乱码
    public static void test01(String[]args){
        //操作System.in和System.out
        //InputStreamReader isr = new InputStreamReader(System.in);
        //OutputStreamWriter osw = new OutputStreamWriter(System.out);
        //增加缓冲
        //操作网络流 下载百度的源代码
        try(InputStream is = new URL("http://www.baidu.com").openStream();){
            //操作读取
            int temp;
            while((temp = is.read())!=-1){
                System.out.print((char)temp);
            }
                   
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
                
    }
}
