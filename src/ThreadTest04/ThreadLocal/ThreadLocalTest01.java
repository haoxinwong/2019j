/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest04.ThreadLocal;

/**
 * ThreadLocal:每个线程自身的存储本地，局部区域
 * get/set/initialValue
 * @author WarSpite
 */
public class ThreadLocalTest01 {
    //大的存储空间
    //private static ThreadLocal<Integer>threadLocal = new ThreadLocal<>();
    //更改初始化值
    /*private static ThreadLocal<Integer>threadLocal = new ThreadLocal<>(){
        protected Integer initialValue(){
            return 200;
        };
    };*/
    private static ThreadLocal<Integer>threadLocal = ThreadLocal.withInitial(()->{
        return 200;
    });
    public static void main(String[] args) {
        //获取值
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
    
        //设置值
        threadLocal.set(99);
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
    
        new Thread(new MyRun()).start();
    }
    
    public static class MyRun implements Runnable{

        @Override
        public void run() {
            threadLocal.set((int)Math.random()*99);//0-98
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());

        }
        
    }
}

