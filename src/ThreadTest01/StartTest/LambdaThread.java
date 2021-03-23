/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest01.StartTest;

/**
 * Lambda表达式简化线程（用一次）的使用
 * @author WarSpite
 */
public class LambdaThread {
    
    //静态内部类
    static class Test implements Runnable{
        /**
         * 线程入口点
         */
        @Override
        public void run() {
            for(int i=0;i<20;i++){
                System.out.println("一边听歌");
            
            }
        
        }
    }

    public static void main(String[] args) {
        
        //new Thread(new Test()).start();
        
        //局部内部类
        class Test2 implements Runnable{
            @Override
            public void run() {
                for(int i=0;i<20;i++){
                    System.out.println("一边听歌");
            
                }
        
            }
        }
        new Thread(new Test2()).start();
        
        //匿名内部类必须借助接口或者父类
        new Thread(new Runnable(){
            public void run() {
                for(int i=0;i<20;i++){
                    System.out.println("一边听歌");
            
                }
        
            }
        }).start();
        
        //jdk8简化 lambda表达式,比较简单的线程体才这样用
        new Thread(()-> {
                for(int i=0;i<20;i++){
                    System.out.println("一边听歌");
            
                }
        
            }
        ).start();
        
    }
}
