/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest04.LockTest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 可重入锁，锁可以延续使用
 * @author WarSpite
 */
public class LockTest01 {
    
    public void test(){
        //第一次获得锁
        synchronized(this){
            while(true){
                //第二次获得同意的锁
                synchronized(this){
                    System.out.println("ReentrantLock");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(LockTest01.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static void main(String[] args) {
        new LockTest01().test();
    }
}
