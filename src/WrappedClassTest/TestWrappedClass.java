/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WrappedClassTest;

/**
 * 测试包装类
 * Integer类的使用
 * @author WarSpite
 */
public class TestWrappedClass {
    public static void main(String[]args){
        //基本数据类型转成包装类对象
        Integer i = new Integer(3);
        //官方推荐这个方法
        Integer b = Integer.valueOf(30);
        
        //把包装类对象转成基本数据类型
        int c = b.intValue();
        double d = b.doubleValue();
        
        //把字符串转成包装类对象
        Integer e = new Integer("9999");
        Integer f = Integer.parseInt("9999888");
        
        //把包装类对象转成字符串
        String str = f.toString(); //""+f
        
        //常见的常量
        System.out.println("int类型最大的整数"+Integer.MAX_VALUE);
        
    }
    
}
