/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubclassTest;

/**
 *
 * @author WarSpite
 */
public class Information {
    /**
     * java中内部类主要分为成员内部类（非静态内部类，静态内部类）匿名内部类
     * 成员内部类可以使用private, default,protected, public 进行修饰
     * a)非静态内部类
     *   1. 非静态内部类必须寄存在一个外部类对象里
     *   2. 可以直接访问外部类的成员，但是外部内不能直接访问内部类的成员，起到非常好的封装
     *   3. 非静态内部类不能使用static方法
     *   3. 外部类的静态方法，静态代码块不能访问非静态内部类
     *      包括不能使用非静态内部类定义变量，创建实例
     * b)静态内部类
     *   1.并不一定存在相应的外部类对象
     *     因此静态内部类的实例方法不能直接访问外部类的实例方法
     *   2.静态内部类看做外部类的一个静态成员
     *     因此外部类的方法可以通过：静态内部类.名字的方法访问静态内部类的静态成员
     *     通过new静态内部类()访问静态内部类的实例
     * c)匿名内部类
     *   1.适合只需要使用一次的类，比如键盘监听操作等
     * d）方法中的内部类
     *   1.只服务于方法
     *   
     * 内部类定义在外部类里面的好处：
     *   1.可以直接使用外部类的成员
     *   2.定义内部类就是为外部类服务的
     * 
     */
    
}
