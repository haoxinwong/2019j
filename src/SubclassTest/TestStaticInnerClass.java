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
public class TestStaticInnerClass {
    public static void main(String[]args){
        //new.外部名.内部名()
        Outer2.Inner2 inner = new Outer2.Inner2();//实例静态内部类
    }
    
}
class Outer2{
    
    static class Inner2{
        
    }
}