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
public class LambdaTest03 {

    public static void main(String[] args) {
        IInterest interest = (int a1,int b2)->{
        System.out.println("I like lambda-->"+a1+"--"+b2);
        return a1+b2;
        };
        interest.lambda(100, 200);
        
        //简化
        interest = (a1,b2)->{
        System.out.println("I like lambda-->"+a1+"--"+b2);
        return a1+b2;
        };
        interest.lambda(200, 200);
        
    }
        
}

interface IInterest{
    int lambda(int a,int b);
}

class Interest implements IInterest{

    public int lambda(int a1,int b2) {
        System.out.println("I like lambda-->"+a1+"--"+b2);
        return a1+b2;
    }
    
}