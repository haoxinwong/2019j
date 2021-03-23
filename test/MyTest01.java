/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WarSpite
 */
public class MyTest01 {
    int age;

    public MyTest01(int age) {
        this.age = age;
    }
    public void setAge(int i){
        this.age = i;
    }
    public static int getNumber(int i){
        return i*2;
    }
    
    public static void main(String[]args){
        MyTest01 test = new MyTest01(10);
        test.setAge(11);
        int time = getNumber(10);
        System.out.println(Math.pow(0, 2));
        
    }
    
}
