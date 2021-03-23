/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractTest;

/**
 *抽象类测试
 * @author WarSpite
 * 1.有抽象方法的类只能定义成抽象类
 * 2.抽象类不能实例化，即不能用new来实例化抽象类
 * 3.抽象类可以包含属性，方法，构造方法，但是构造方法不能用new实例
 * 4.抽象类只能用来被继承
 * 5.抽象方法必须被子类实现
 */
//抽象方法必须是在抽象类下面
//抽象方法第一没有实现，第二子类必须实现
//抽象类给子类提供了设计规范
public abstract class Animal {
    /**
     * 加了abstract之后就变成了抽象方法
     */
    abstract public void shout();
    
    public void run(){
        System.out.println("跑跑");
    }
    
    public static void main(String[]args){
        //可以new子类
        Animal a = new Dog();
    }
}
class Dog extends Animal{
    public void shout(){
        System.out.println("狗叫");
    }
}
