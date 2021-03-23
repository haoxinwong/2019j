/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringTest;

/**
 * 测试字符序列
 * 
 * @author WarSpite
 */
public class TestString {
    public static void main(String[]args){
        String str = "abc";
        String str2 = new String("def");
        String str3 = "abc"+"defgh";
        
        String str4 = "18"+19;//不是假发，是字符串连接符
        
        System.out.println("#####");
        /**
         * 
         */
        String str10 = "hao";
        String str11 = "hao";
        String str12 = new String("hao");
        
        System.out.println(str10 == str11);
        System.out.println(str12 == str11);//str11和str12不是同一个对象
        
        //通常比较字符串时，使用equals
        System.out.println(str11.equals(str12));
    }
}
