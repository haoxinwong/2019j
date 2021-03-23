/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest03.UnsafeTest;

/**
 * 线程不安全，数据有负数，相同
 * @author WarSpite
 */
public class UnsafeTest01 {
    public static void main(String[] args) {
        //一份资源
        UnsafeWeb12306 web = new UnsafeWeb12306();
        
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web,"王一").start();
        new Thread(web,"赵二").start();
        new Thread(web,"张三").start();
    }
}

class UnsafeWeb12306 implements Runnable{
    //票数
    private int ticketNums = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while(flag){
            test();
        }
    }
    
    public void test(){
        if(ticketNums<0){
            flag = false;
            return ;
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
