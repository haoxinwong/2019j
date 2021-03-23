/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest02.YieldTest;

/**
 * yield 礼让线程，暂停线程 直接进入就绪状态不是阻塞状态
 * @author WarSpite
 */
public class YieldTest01 {
    public static void main(String[] args) {
        MyYield my = new MyYield();
        new Thread(my,"浩").start();
        new Thread(my,"王").start();
    }
}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->start");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+"-->end");
    }
    
}
