/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest01.RacerTest;


/**
 * Code example "Racer"
 * @author WarSpite
 */
public class Racer implements Runnable {
    private static String winner;

    @Override
    public void run() {
        for(int steps = 1;steps<=100;steps++){
            //Simulated break
            if(Thread.currentThread().getName().equals("rabbit")&&steps%10==0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"--->"+steps);
            //Game over
            boolean flag = gameOver(steps);
            if(flag){
                break;
            }
        }
        
    }
    
    private boolean gameOver(int steps){
        if(winner!=null){
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
    
    public static void main(String[] args) {
        Racer racer =  new Racer();
        new Thread(racer,"tortoise").start();
        new Thread(racer,"rabbit").start();
        
    }
    
}
