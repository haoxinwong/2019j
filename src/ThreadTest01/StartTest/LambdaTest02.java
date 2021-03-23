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
public class LambdaTest02 {

    public static void main(String[] args) {
        ILove love = (int a)->{
        System.out.println("I like lambda-->"+a);
        };
        
        love.lambda(100);
        
        //简化
        love = (a)->{
        System.out.println("I like lambda-->"+a);
        };
        love.lambda(50);
        
        //只有一个参数，可以省略括号
        love = a->{
        System.out.println("I like lambda-->"+a);
        };
        love.lambda(25);
        
        //如果只是一行代码，还可以省略
        love = a->System.out.println("I like lambda-->"+a);
        love.lambda(5);
        
    }
        
}

interface ILove{
    void lambda(int a);
}

class Love implements ILove{

    @Override
    public void lambda(int a) {
        System.out.println("I like lambda-->"+a);
    }
    
}