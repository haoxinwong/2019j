/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest04.ThreadLocal;

/**
 * InheritableThreadLocal:继承上下文 环境的数据,拷贝一份给子线程
 * 1.构造器：哪里调用 就属于哪里 找线程体
 * 2.run方法：本线程自身的
 * @author WarSpite
 */
public class ThreadLocalTest04 {
    
    private static ThreadLocal<Integer>threadLocal = new InheritableThreadLocal<>();
    public static void main(String[] args) {
        threadLocal.set(2);
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        
        //线程由main线程开辟
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
            threadLocal.set(200);
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());

        }).start();
    }
    
    public static class MyRun implements Runnable{

        public MyRun() {
            threadLocal.set(-100);
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());

        }
        
        

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"还剩下-->"+threadLocal.get());
            new Thread(new MyRun()).start();
        }
        
    }
}

