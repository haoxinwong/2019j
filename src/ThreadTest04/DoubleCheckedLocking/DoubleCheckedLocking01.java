/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest04.DoubleCheckedLocking;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 单例模式：懒汉式套路基础上加入并发控制套路，保证在多线程环境下，对外存在一个对象
 * 1.构造器私有化-->避免外部new构造器
 * 2.提供私有的静态属性-->存储对象的地址
 * 3.提供公共的静态方法-->获取属性
 * 
 * @author WarSpite
 */
public class DoubleCheckedLocking01 {
    //2.提供私有的静态属性
    //volatile 避免指令重排
    //没有volatile其他线程可能访问一个没有初始化的对象
    private volatile static DoubleCheckedLocking01 instance;
    //1.构造器私有化
    private DoubleCheckedLocking01(){
        
    }
    //3.提供公共的静态方法
    public static DoubleCheckedLocking01 getInstance(){
        //再次检测
        if(null!=instance){//避免不必要的同步，已经存在对象
            return instance;
            
        }
        synchronized(DoubleCheckedLocking01.class){
            if(null==instance){
                instance = new DoubleCheckedLocking01();
                //new 对象会做三件事情
                /*
                1.开辟空间
                2.初始化对象信息
                3.返回对象的地址个引用
                */
            }
        }
        return instance;
    }
    
    public static DoubleCheckedLocking01 getInstance1(long time){
        synchronized(DoubleCheckedLocking01.class){
            if(null==instance){
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DoubleCheckedLocking01.class.getName()).log(Level.SEVERE, null, ex);
                }
                instance = new DoubleCheckedLocking01();
                //new 对象会做三件事情
                /*
                1.开辟空间
                2.初始化对象信息
                3.返回对象的地址个引用
                */
            }
        }
        return instance;
    }
    
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println(DoubleCheckedLocking01.getInstance1(500));
        });
        t.start();
        System.out.println(DoubleCheckedLocking01.getInstance1(1000));

    }
}
