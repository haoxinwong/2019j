/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest03.SynchronizedTest;

import ThreadTest03.UnsafeTest.*;

/**
 * 线程安全:在并发时保证数据的正确性，效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步快
 * @author WarSpite
 */
public class SynchronizedBlockTest03 {
    public static void main(String[] args) {
        //一份资源
        SynchronizedWeb12306 web = new SynchronizedWeb12306();
        
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web,"王一").start();
        new Thread(web,"赵二").start();
        new Thread(web,"张三").start();
    }
}

class SynchronizedWeb12306 implements Runnable{
    //票数
    private int ticketNums = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while(flag){
            try {
                //模拟网络延时
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            test5();
        }
    }
    
    //尽可能锁定合理的范围
    public synchronized void test5(){
        if(ticketNums<=0){//考虑的是没有票的情况
                flag = false;
                return ;
            }
        synchronized(this){
            if(ticketNums<=0){//考虑最后的1张票
                flag = false;
                return ;
            }
            try {
                //模拟网络延时
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
        }
    }
    
    //线程不安全 范围太小，锁不住
    public synchronized void test4(){
        synchronized((Integer)ticketNums){
            if(ticketNums<=0){
                flag = false;
                return ;
            }
        }
            try {
                //模拟网络延时
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
        
    }
    
    //线程不安全 ticketNums对象在变
    public synchronized void test3(){
        synchronized((Integer)ticketNums){
            if(ticketNums<=0){
                flag = false;
                return ;
            }
            try {
                //模拟网络延时
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
        }
    }
    
    //线程安全 范围太大-->效率低下
    public synchronized void test2(){
        synchronized(this){
            if(ticketNums<=0){
                flag = false;
                return ;
            }
            try {
                //模拟网络延时
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
        }
    }

    
    //线程安全 同步
    public synchronized void test1(){
        if(ticketNums<=0){
            flag = false;
            return ;
        }
        try {
            //模拟网络延时
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
    }

}
