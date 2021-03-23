/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.TestConvert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 转换流：InputStreamReader&OutputStreamWriter
 * 1.以字符流的形式操作字节流（纯文本）
 * 2.指定字符集
 * @author WarSpite
 */
public class ConvertTest01 {
    public static void main(String[]args){
        //操作System.in和System.out
        //InputStreamReader isr = new InputStreamReader(System.in);
        //OutputStreamWriter osw = new OutputStreamWriter(System.out);
        //增加缓冲
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));){
            //循环获取键盘的输入（exit退出），输出此内容
            String msg = "";
            while(!msg.equals("exit")){
                msg = reader.readLine();//循环读取
                writer.write(msg);//循环写出
                writer.newLine();
                writer.flush();//内容比较少，如果不强制刷新，就写不出去
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
                
    }
}
