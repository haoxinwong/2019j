/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubclassTest;

/**
 * 测试非静态内部类(成员内部类）
 * @author WarSpite
 */
public class TestInnerClass {
    public static void main(String[]args){
        
        //创建内部类对象
        //有内部类对象，必然也有外部类对象
        Outer.Inner inner = new Outer().new Inner();
        inner.show();//访问
    }
    
}
class Outer{
    private int age =10;
    public void testOuter(){
        System.out.println("Outer.testOuter()");
    }
    //虽然Inner在Outer里面，但是生成两个不同的class
    //非静态
    class Inner{
        //定义内部类自己的属性
        int age = 20;
        public void show(){
            //定义局部变量
            int age = 30;
            System.out.println("外部类的成员变量age："+Outer.this.age);//外部类变量，加Outer
            System.out.println("内部类的成员变量age："+this.age);//内部类变量，加this
            System.out.println("局部变量age："+age);//局部变量，不用加this

        }
    }
}
