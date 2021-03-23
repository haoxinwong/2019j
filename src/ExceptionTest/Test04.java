/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionTest;

/**
 * 自定义异常
 * @author WarSpite
 */
public class Test04 {
    public static void main(String[]args){
        Person p = new Person();
        p.setAge(-2);
    }
    
}
class Person{
    private int age;
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        if(age<0){
            throw new IllegalAgeException("年龄不能为负数");
        }
        this.age = age;
    }
}

class IllegalAgeException extends RuntimeException{//如果继承Exception，编译器处理
    public IllegalAgeException(){
        
    }
    
    public IllegalAgeException(String msg){
        super(msg);
    }
}
