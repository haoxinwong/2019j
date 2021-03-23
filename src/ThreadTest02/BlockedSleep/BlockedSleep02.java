/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest02.BlockedSleep;

/**
 * sleep模拟休息
 * @author WarSpite
 */
public class BlockedSleep02 {
    public static void main(String[] args) {
        Racer racer =  new Racer();
        new Thread(racer,"tortoise").start();
        new Thread(racer,"rabbit").start();
        
    }
}

class Racer implements Runnable {
    private static String winner;//胜利者

    @Override
    public void run() {
        for(int steps = 1;steps<=100;steps++){
            //模拟休息
            if(Thread.currentThread().getName().equals("rabbit")&&steps%10==0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"--->"+steps);
            //比赛是否结束
            boolean flag = gameOver(steps);
            if(flag){
                break;
            }
        }
        
    }
    
    private boolean gameOver(int steps){
        if(winner!=null){//是否存在胜利者
            return true;
        }else{
            if(steps==100){
                winner = Thread.currentThread().getName();
                System.out.println("winner-->"+winner);
                return true;
            }
        }
        return false;
    }
    
    
    
}
