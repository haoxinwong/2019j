/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest04.ThreadLocal;

/**
 * ThreadLocal:分析上下文 环境 起点
 * 1.构造器：哪里调用 就属于哪里 找线程体
 * 2.run方法：本线程自身的
 * @author WarSpite
 */
public class ThreadLocalTest03 {
    
    private static ThreadLocal<Integer>threadLocal = ThreadLocal.withInitial(()->{
        return 1;
    });
    public static void main(String[] args) {
        new Thread(new MyRun()).start();
        new Thread(new MyRun()).start();
    }
    
    public static class MyRun implements Runnable{

        public MyRun() {
            threadLocal.set(-100);
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());

        }
        
        

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"还剩下-->"+threadLocal.get());
        }
        
    }
}

