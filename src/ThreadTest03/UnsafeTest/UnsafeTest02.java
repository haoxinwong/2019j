/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest03.UnsafeTest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 线程不安全：取钱
 * @author WarSpite
 */
public class UnsafeTest02 {
    public static void main(String[] args) {
        //账户
        Account account = new Account(100,"金");
        Drawing you = new Drawing(account,80,"浩");
        Drawing wife = new Drawing(account,90,"王");
        you.start();
        wife.start();
    }
}


//模拟取款
class Drawing extends Thread{
    Account account;//取钱的账户
    int drawingMoney;//取的钱数
    int packetTotal;//口袋的总数

    public Drawing(Account account, int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    
    
    @Override
    public void run() {
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