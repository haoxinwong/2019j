/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest02.BlockedSleep;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author WarSpite
 */
public class BlockedSleep03 {
    public static void main(String[] args) throws InterruptedException {
        //倒计时
        Date endTime = new Date(System.currentTimeMillis()+10*1000);
        long end = endTime.getTime();
        while(true){
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(1000);
            endTime = new Date(endTime.getTime()-1000);
            if(end-10000>endTime.getTime()){
                break;
            }
        }
    }
    
    public static void test() throws InterruptedException {
        //倒数10个数，1秒一个
        int num = 10;
        while(true){
            Thread.sleep(1000);
            System.out.println(num--);
        }
    }
}
