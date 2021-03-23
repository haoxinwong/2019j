/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest03.SynchronizedTest;

import ThreadTest03.UnsafeTest.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 线程安全:在并发时保证数据的正确性，效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步快
 * @author WarSpite
 */
public class SynchronizedTest02 {
    public static void main(String[] args) {
        //账户
        Account account = new Account(100,"金");
        SafeDrawing you = new SafeDrawing(account,80,"浩");
        SafeDrawing wife = new SafeDrawing(account,90,"王");
        you.start();
        wife.start();
    }
}



//模拟取款
class SafeDrawing extends Thread{
    Account account;//取钱的账户
    int drawingMoney;//取的钱数
    int packetTotal;//口袋的总数

    public SafeDrawing(Account account, int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    
    
    @Override
    public void run() {
        test();
        }
    //目标不对锁定失败，这里不是锁this 应该锁定account
    public synchronized void test(){
        if(account.money-drawingMoney<0){
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        account.money -= drawingMoney;
        packetTotal += drawingMoney;
        System.out.println(this.getName()+"-->账户余额为："+account.money);
        System.out.println(this.getName()+"-->口袋的钱为："+packetTotal);
    }
    
}