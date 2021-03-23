/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest02.BlockedJoinTest;

/**
 *
 * @author WarSpite
 */
public class BlockedJoin01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for(int i = 0;i<100;i++){
                System.out.println("lambda--"+i);
            }
            
        });
        t.start();
        
        for(int i=0;i<100;i++){
            if(i==20){
                //20前大家一起走，20后要等到lambda走完，再走main
                t.join();//插队 main被阻塞了
            }
            System.out.println("main--"+i);
        }
    }
}
