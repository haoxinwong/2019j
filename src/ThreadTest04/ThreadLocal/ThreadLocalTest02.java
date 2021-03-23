/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest04.ThreadLocal;

/**
 * ThreadLocal:每个线程自身的数据，更改不会影响其他线程
 * @author WarSpite
 */
public class ThreadLocalTest02 {
    
    private static ThreadLocal<Integer>threadLocal = ThreadLocal.withInitial(()->{
        return 1;
    });
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(new MyRun()).start();

        }
    }
    
    public static class MyRun implements Runnable{

        @Override
        public void run() {
            Integer left = threadLocal.get();
            System.out.println(Thread.currentThread().getName()+"得到了-->"+left);
            threadLocal.set(left-1);
            System.out.println(Thread.currentThread().getName()+"还剩下-->"+threadLocal.get());

        }
        
    }
}

