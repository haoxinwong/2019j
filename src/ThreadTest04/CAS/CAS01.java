/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest04.CAS;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Compare and Swap - 比较并交换
 * @author WarSpite
 */
public class CAS01 {
    //库存
    private static AtomicInteger stock = new AtomicInteger(5);
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(()->{
                //模拟网络延时
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CAS01.class.getName()).log(Level.SEVERE, null, ex);
                }
                Integer left = stock.decrementAndGet();
                if(left<1){
                    System.out.println("抢完了");
                    return;
                }
                System.out.println(Thread.currentThread().getName()+"抢了一件");
                System.out.println("-->还剩"+left);
            }).start();
        }
    }
}
