/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceTest;

/**
 * 测试接口和实现类
 * @author WarSpite
 */
public class TestInterface {
    public static void main(String[]args){
        Volant v = new Angel();//new Angel的实例
        v.fly();
        
        Honest h = new GoodMan();//new goodman的实例,不能new接口
        h.helpOther();
    }
}

/**
 * 飞行接口
 */
interface Volant{
    int FLY_HEIGHT = 1000;
    void fly();
}

/**
 * 善良接口
 */
interface Honest{
    void helpOther();
}

class Angel implements Volant,Honest{//可以implements多个接口

    @Override
    public void fly() {
        System.out.println("Angel.helpOther ");
    }

    @Override
    public void helpOther() {
        System.out.println("Angel.fly()");
    }
    
}
 class GoodMan implements Honest{

    @Override
    public void helpOther() {
        System.out.println("GoodMan.helpOther()");
    }
     
 }