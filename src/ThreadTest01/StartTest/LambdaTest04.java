/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest01.StartTest;

/**
 * lambda推导
 * 由外部类，变成静态内部类，再变成匿名内部类，再变成lambda
 * @author WarSpite
 */
public class LambdaTest04 {

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("一边看电视");
        }).start();
        
        new Thread(()->{
            System.out.println("一边玩手机");
        }).start();
        
        new Thread(()->System.out.println("一边玩手机")).start();
        
    }
        
}

