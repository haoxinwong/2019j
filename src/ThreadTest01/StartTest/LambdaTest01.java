/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest01.StartTest;

/**
 * 避免匿名内部类定义过多
 * lambda推导
 * 由外部类，变成静态内部类，再变成匿名内部类，再变成lambda
 * @author WarSpite
 */
public class LambdaTest01 {
    //内部类也可以
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I like lambda");
        }
    
    }
    public static void main(String[] args) {
        ILike like = new Like();
        
        like = new Like2();
        like.lambda();
        
        //匿名内部类
        like = new ILike(){
            public void lambda(){
                System.out.println("I like lambda");
            }
        };
        
        //lambda
        like = ()->{
            System.out.println("I like lambda5");
        };
    }
}

interface ILike{
    void lambda();
}

class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
    
}