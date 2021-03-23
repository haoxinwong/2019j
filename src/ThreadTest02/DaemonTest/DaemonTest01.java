/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest02.DaemonTest;

/**
 * 守护线程：是为用户线程服务的，jvm停止不用等到守护线程执行完毕
 * 默认：用户线程 虚拟机等待所有的用户线程执行完毕才会停止
 * @author WarSpite
 */
public class DaemonTest01 {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread t = new Thread(god);
        
        t.setDaemon(true);//将用户线程调整为守护
        t.start();
        new Thread(you).start();
    }
}

class You implements Runnable{

    @Override
    public void run() {
        for(int i = 1;i<=365*100;i++){
            System.out.println("happy life");
        }
        System.out.println("ooooo");
    }
    
}

class God implements Runnable{
    @Override
    public void run() {
        for(;true;){
            System.out.println("bless people");
        }
    }
}