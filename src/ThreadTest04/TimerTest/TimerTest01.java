/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest04.TimerTest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author WarSpite
 */
public class TimerTest01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //执行安排
        //timer.schedule(new MyTask(), 1000);//执行任务一次每隔一秒(执行任务一次）
        //timer.schedule(new MyTask(), 1000,200);//两百毫秒以后再重复执行任务（执行多次）
        Calendar cal = new GregorianCalendar(2019,7,2,12,30,50);
        timer.schedule(new MyTask(), cal.getTime(),200);//指定时间
        
    }
}

class MyTask extends TimerTask{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Hello World");
        }
        System.out.println("--end--");
    }
    
}