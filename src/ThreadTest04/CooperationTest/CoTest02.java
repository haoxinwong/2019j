/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest04.CooperationTest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 协作模式：生产者消费者实现方式二：信号灯法
 * 借助标志
 * @author WarSpite
 */
public class CoTest02 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

//生产者 演员
class Player extends Thread{
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }
    
    public void run(){
        for(int i=0;i<20;i++){
            if(i%2==0){
                this.tv.play("说");
            }else{
                this.tv.play("白");
            }
        }
    }
}
//消费者 观众
class Watcher extends Thread{
    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }
    
    public void run(){
        for(int i=0;i<20;i++){
            tv.watch();
        }
    }
}
//同一个资源 电视
class Tv{
    String voice;
    //信号灯
    //T表示演员表演 观众等待
    //F表示观众观看 演员等待
    boolean flag = true;
    
    //表演
    public synchronized void play(String voice){
        //演员等待
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Tv.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //表演
        System.out.println("表演了："+voice);
        this.voice = voice;
        //唤醒
        this.notifyAll();
        //切换标志
        this.flag = !this.flag;
    }
    
    //观看
    public synchronized void watch(){
        //观众等待
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Tv.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //观看
        System.out.println("听到了："+voice);
        //唤醒
        this.notifyAll();
        //切换标志
        this.flag = !this.flag;
    }
}