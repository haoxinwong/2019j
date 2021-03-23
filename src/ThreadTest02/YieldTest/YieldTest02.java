/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest02.YieldTest;

/**
 *
 * @author WarSpite
 */
public class YieldTest02 {
    public static void main(String[] args) {
        new Thread(()->{
            for(int i = 0;i<100;i++){
                System.out.println("lambda--"+i);
            }
            
        }).start();
        
        for(int i=0;i<100;i++){
            if(i%20==0){
                Thread.yield();//main礼让
            }
            System.out.println("main--"+i);
        }
    }
}
