/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceTest;

/**
 * 面向接口编程
 * 设计要比实现难，因为需求多变
 * 而接口能以不变应万变,减低程序模块间的耦合性
 * 提高程序的可扩展性和可维护性
 * @author WarSpite
 */
public class TestInterface2 {
    
}

interface A {
    void testa();
}
interface B {
    void testb();
}
/**接口可以多继承：接口C继承接口A和B*/
//C接口包含A和B接口
/**
 * 
 * java里面有没有多继承：java的类只有单继承，但是java的接口有多继承
 * 
 */
interface C extends A, B {
    void testc();
}
class Test implements C {
    public void testc() {
    }
    public void testa() {
    }
    public void testb() {
    }
}
