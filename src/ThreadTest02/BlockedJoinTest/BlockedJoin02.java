/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest02.BlockedJoinTest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WarSpite
 */
public class BlockedJoin02 {
    public static void main(String[] args) {
        System.out.println("爸爸和儿子买烟的故事");
        new Thread(new Father()).start();
    }
}
class Father extends Thread{
    public void run(){
        System.out.println("想抽烟，发现没了");
        System.out.println("让儿子去买中华");
        Thread t = new Thread(new Son());
        t.start();
        try {
            t.join();//father被阻塞了
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            System.out.println("孩子走丢了，老爸找孩子去了");
        }
        System.out.println("老爸接过烟");
    }
    
}

class Son extends Thread{
    public void run(){
        System.out.println("接过老爸的钱出去了");
        System.out.println("路边有个游戏厅，玩了10秒");
        for(int i =0;i<10;i++){
            System.out.println(i+"秒过去了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("赶紧买烟去");
        System.out.println("回家");
    }
}