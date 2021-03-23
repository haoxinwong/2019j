/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest04.Volatile;

/**
 * volatile 用于保证数据的同步，也就是可见性
 * @author WarSpite
 */
public class VolatileTest {
    //加入volatile之后，一秒后就能同步，保证数据的同步
    private volatile static int num = 0;
    
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while(num == 0){//此处不要编写代码，死循环
                //电脑太忙，没有时间去同步num，所以会一直循环
            }
                
        }).start();
        
        //理论上，一秒后循环会停下来
        Thread.sleep(1000);
        num = 1;
    }
}
