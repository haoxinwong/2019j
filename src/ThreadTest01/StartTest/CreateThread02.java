/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest01.StartTest;

/**
 * 创建线程方式二：
 * 1.创建：实现Runnable+重写Run
 * 2.启动：创建实现类对象+Thread对象+start
 * 
 * 推荐：避免单继承的局限性，优先使用接口
 * 方便共享资源
 * @author WarSpite
 */
public class CreateThread02 implements Runnable{
    
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println("一边听歌");
            
        }
        
    }

    public static void main(String[] args) {
        /*
        //创建实现类对象
        CreateThread02 ct = new CreateThread02();
        //创建代理类对象
        Thread t = new Thread(ct);
        //启动
        t.start();
        */
        //如果一个对象只使用一次，可以这么做
        new Thread(new CreateThread02()).start();
        for(int i=0;i<20;i++){
            System.out.println("一边coding");
            
        }
    }
}
