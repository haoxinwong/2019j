/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest;

import java.io.UnsupportedEncodingException;

/**
 * 编码：字符串-->字节
 * 解码：字节--->字符串
 * @author WarSpite
 */
public class ContentEncode {
    public static void main(String[]args) throws UnsupportedEncodingException{
        String m = "号号好浩耗";
        
        //编码：字节数组
        byte[]datas = m.getBytes();//默认使用工程字符集
        System.out.println(datas.length);
        
        //编码：其他字符集
        datas = m.getBytes("UTF-16LE");
        System.out.println(datas.length);
        datas = m.getBytes("GBK");
        System.out.println(datas.length);
        
        //解码：字符串String(byte[]bytes,int offset, int length,String charsetName)
        m = new String(datas,0,datas.length,"GBK");
        System.out.println(m);
        
        //乱码：
        //1.字节数不够
        m = new String(datas,0,datas.length-2,"GBK");
        System.out.println(m);
        
        //2.字符集不统一
        m = new String(datas,0,datas.length-2,"utf8");
        System.out.println(m);
    }
    
}
