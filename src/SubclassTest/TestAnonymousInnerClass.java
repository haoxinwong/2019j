/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubclassTest;

/**
 * 匿名内部类
 * @author WarSpite
 */
public class TestAnonymousInnerClass {
    public static void main(String[]args){
        TestAnonymousInnerClass.test01(new AA(){
            @Override
            public void aa() {
                System.out.println("TestAnonymousInnerClass.main(...).new AA(){...}.aa()");
                
            }    
        });
    }
    
    public static void test01(AA a){
        System.out.println("#########");
        a.aa();
    }
    
}


interface AA{
    void aa();
    
}

