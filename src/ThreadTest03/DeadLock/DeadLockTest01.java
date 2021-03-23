/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest03.DeadLock;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 死锁：过多的同步可能造成相互不释放资源
 * 从而相互等到，一般发生于同步中持有多个对象的锁
 * 
 * 避免：不要在同一个代码块中，同时持有多个对象的锁
 * @author WarSpite
 */
public class DeadLockTest01 {
    public static void main(String[] args) {
        Markup g1 = new Markup(1,"浩");
        Markup g2 = new Markup(0,"王");
        
        g1.start();
        g2.start();
        
    }
}

//口红
class Lipstick{
    
}

//镜子
class Mirror{
    
}

//化妆
class Markup extends Thread{
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    //选择
    int choice;
    //名字
    String name;
    
    public Markup(int choice,String name) {
        this.choice = choice;
        this.name = name;
    }
    
    @Override
    public void run(){
        //化妆
        makeup();
    }
    
    //相互持有对方的对象锁-->可能造成死锁
    private void makeup(){
        if(choice==0){
            synchronized(lipstick){
                System.out.println(this.name+"涂口红");
                try {
                    //一秒后想拥有镜子的锁
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                /*synchronized(mirror){
                    System.out.println(this.name+"照镜子");
                }*/
            }
            synchronized(mirror){
                    System.out.println(this.name+"照镜子");
                }
        }else{
            synchronized(mirror){//获得镜子的锁
                System.out.println(this.name+"照镜子");
                try {
                    //2秒后想涂口红
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                /*synchronized(lipstick){
                    System.out.println(this.name+"涂口红");
                }*/
            }
            synchronized(lipstick){
                System.out.println(this.name+"涂口红");
            }
        }
    }
}