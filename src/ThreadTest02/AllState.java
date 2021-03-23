/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest02;

import java.lang.Thread.State;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WarSpite
 */
public class AllState {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for(int i = 0;i<5;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println("---");
            }
        });
        //观察状态
        State state = t.getState();
        System.out.println(state.toString());//NEW
        
        t.start();
        state = t.getState();
        System.out.println(state.toString());//RUNNABLE
        /*
        while(state!=Thread.State.TERMINATED){
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            state = t.getState();//TIMED_WAITING
            System.out.println(state.toString());
        }
        */
        while(true){
            //活动的线程数
            int num = Thread.activeCount();
            System.out.println(num);
            if(num==1){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            state = t.getState();//TIMED_WAITING
            System.out.println(state.toString());
        }

    }
}
