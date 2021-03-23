/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MathTest;

/**
 *
 * @author WarSpite
 */
public class TestMath {
    public static void main(String[]args){
        //取整相关操作
        System.out.println(Math.ceil(3.2));//4.0
        System.out.println(Math.floor(3.2));//3.0
        System.out.println(Math.round(3.2));//3
        System.out.println(Math.round(3.8));//4
        //绝对值、开方、a的b次幂等操作
        System.out.println(Math.abs(-45));//45
        System.out.println(Math.sqrt(64));//8.0
        System.out.println(Math.pow(5, 2));//25.0,5的2次方
        System.out.println(Math.pow(2, 5));//32.0,2的5次方
        //Math类中常用的常量
        System.out.println(Math.PI);//3.14
        System.out.println(Math.E);//2.71
        //随机数
        System.out.println(Math.random());// [0,1)
    }
    
    
}
