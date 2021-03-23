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
public class SynchronizedTest01 {
    public static void main(String[] args) {
        //一份资源
        SafeWeb12306 web = new SafeWeb12306();
        
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web,"王一").start();
        new Thread(web,"赵二").start();
        new Thread(web,"张三").start();
    }
}

class SafeWeb12306 implements Runnable{
    //票数
    private int ticketNums = 10000;
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
            test();
        }
    }
    //线程安全 同步
    public synchronized void test(){
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
