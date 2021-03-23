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
 * 2.同步块,目标更明确
 * @author WarSpite
 */
public class SynchronizedBlockTest02 {
    public static void main(String[] args) {
        //账户
        Account account = new Account(1000,"金");
        SynDrawing you = new SynDrawing(account,80,"浩");
        SynDrawing wife = new SynDrawing(account,90,"王");
        you.start();
        wife.start();
    }
}



//模拟取款 线程安全
class SynDrawing extends Thread{
    Account account;//取钱的账户
    int drawingMoney;//取的钱数
    int packetTotal;//口袋的总数

    public SynDrawing(Account account, int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    
    
    @Override
    public void run() {
        test();
        }
    //目标锁定account
    public void test(){
        //提高性能代码
        if(account.money<drawingMoney){
            return;
        }
        //同步块
        synchronized(account){
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
    
}