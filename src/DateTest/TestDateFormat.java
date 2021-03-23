/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateTest;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import javafx.scene.input.DataFormat;

/**
 * 测试时间对象和字符串之间的互相转换
 * DataFormat抽象类和SimpleDateFormat实现类的使用
 * @author WarSpite
 */
public class TestDateFormat {
    public static void main(String[]args) throws ParseException{
        //把时间对象按照“格式字符串指定的格式”转成相应的字符串
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str = df.format(new Date(4000000));
        System.out.println(str);
        
        //把字符串按照"格式字符串指定的格式”转成相应的时间对象
        DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        Date date = df2.parse("1983年05月10日 10时45分59秒");
        
        //测试其他的格式字符.比如：利用D 获得本时间对象是所处年份的第几天
        DateFormat df3 = new SimpleDateFormat("D");
        String str2 = df3.format(new Date());
        System.out.println(str2);
        
    }
}
