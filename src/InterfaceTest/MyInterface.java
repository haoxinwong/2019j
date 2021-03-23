/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceTest;

/**
 *
 * @author WarSpite
 * 接口
 * 接口是比抽象类更加抽象的类，可以更加规范的对子类进行约束
 * 接口中所有的方法都是抽象方法
 * 从接口实现者的角度看，接口定义了可以向外部提供的服务
 * 从接口调用者的角度看，接口定义了实现者能提供的哪些服务
 * 接口是两个模块之间的通信标准，完成接口就等于完成了系统的设计大纲
 * 接口和实现类不是父子关系，是实现规则的关系
 * 比如定义一个Runable的接口，Car实现他就能在地上跑，Train实现他也能再地上跑
 * 
 */
public interface MyInterface {//可以extends多个接口
    //接口中的属性只能是常量:public static final,不写也是，默认的
    int NUMS = 100;
    //接口中的方法只能是：public abstract，不写也是，默认的
    void test01();
    
}
class MyClass implements MyInterface{//使用implements
    
     //必须实现
    @Override
    public void test01() {
        System.out.println("lala");
    }
    
    
}
