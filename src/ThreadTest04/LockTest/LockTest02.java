/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest04.LockTest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 不可重入锁，锁不可以延续使用
 * @author WarSpite
 */
public class LockTest02 {
    Lock lock = new Lock();
    public void a() throws InterruptedException{
        lock.lock();
        doSomething();
        lock.unlock();
    }
    //不可重入
    public void doSomething() throws InterruptedException{
        lock.lock();
        //......
        lock.unlock();

    }
    public static void main(String[] args) throws InterruptedException {
       LockTest02 test = new LockTest02();
       test.a();
       test.doSomething();
    }
}
//不可重入锁
class Lock{
    //是否占用
    private boolean isLocked = false;
    
    //使用锁
    public synchronized void lock() throws InterruptedException{
        while(isLocked){
            wait();
        }
        isLocked = true;
    }
    
    //释放锁
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}