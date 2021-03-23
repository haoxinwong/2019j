/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest02.BlockedSleep;

/**
 * sleep模拟网络延时，放大了发生问题的可能性
 * @author WarSpite
 */
public class BlockedSleep01 {
    public static void main(String[] args) {
        //一份资源
        Web12306 web = new Web12306();
        
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web,"王一").start();
        new Thread(web,"赵二").start();
        new Thread(web,"张三").start();
    }
}

class Web12306 implements Runnable{
    //票数
    private int ticketNums = 99;

    @Override
    public void run() {
        while(true){
            if(ticketNums<0){
                break;
            }
            try {
                //模拟网络延时
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
        }
    }

}

