/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest02.ProrityTest;

/**
 * 线程的优先级1-10
 * 1.NORM_PRIORITY
 * 2.MIN_PRIORITY
 * 3.MAX_PRIORITY
 * 概率，不代表绝对的先后顺序
 * @author WarSpite
 */
public class PriorityTest01 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
        MyPriority mp = new MyPriority();
        
        Thread t1 = new Thread(mp,"a");
        Thread t2 = new Thread(mp,"b");
        Thread t3 = new Thread(mp,"c");
        Thread t4 = new Thread(mp,"d");
        Thread t5 = new Thread(mp,"e");
        Thread t6 = new Thread(mp,"f");        
        
        //设置优先级在启动前
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(Thread.NORM_PRIORITY);
        t5.setPriority(Thread.MIN_PRIORITY);
        t6.setPriority(Thread.MIN_PRIORITY);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
        Thread.yield();
    }
    
}