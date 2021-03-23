/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionTest;

/**
 * 运行时异常的处理
 * RuntimeException
 * @author WarSpite
 */
public class Test01 {
    public static void main(String[]args){
        /**
         * ArithmeticException - 数学错误
         */
        int a = 0;
        int b = 1;
        if(a!=0){
            System.out.println(b/a);
        }
        /**
         * NullPointerException - 空指针
         */
        String str = null;
        if(str!=null){
            System.out.println(str.length());
        }
        /**
         * ClassCastException
         */
        Animal d = new Dog();
        if(d instanceof Cat){
            Cat c = (Cat)d;
        }
        /**
         * ArrayIndexOutOfBoundsException
         */
        int[]arr = new int[5];
        int a2 = 5;
        if(a2<arr.length){
            System.out.println(arr[a2]);
        }
        
        
    }
    
}

class Animal{
    
}
class Dog extends Animal{
    
}
class Cat extends Animal{
    
}