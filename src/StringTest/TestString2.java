/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringTest;

/**
 * 测试String的常用方法
 * @author WarSpite
 */
public class TestString2 {
    public static void main(String[]args){
        
        String s1 = "core java";
        String s2 = "CORE java";
        System.out.println(s1.charAt(2));
        
        System.out.println(s2.length());
        
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
        
        System.out.println(s1.indexOf("java"));
        System.out.println(s1.indexOf("apple"));
        
        String ss = s1.replace(" ","&");
        System.out.println(ss);
        ss = s1.replaceAll(" ", "");
        System.out.println(ss);
        
        String s = "";
        String s3 = "How are you?";
        System.out.println(s3.startsWith("How"));//检查前面
        System.out.println(s3.endsWith("you"));//检查后面
        
        s = s3.substring(4);//从4开始到之后的数字
        System.out.println(s);
        s = s3.substring(4,7);//下标[4,7],不包括7
        System.out.println(s);
        
        s = s3.toLowerCase();
        System.out.println(s);
        s = s3.toUpperCase();
        System.out.println(s);
        
        String s4 = " How old are you!! ";
        s = s2.trim();//去掉字符串首尾的空格，不包括中间
        System.out.println(s);
        System.out.println(s2);
        
        

        
        
        
    }
    
}
