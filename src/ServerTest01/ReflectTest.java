/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerTest01;

import static java.lang.Class.forName;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射：把java类中的各种结构（方法，属性，构造器，类名）映射成一个个Java对象
 * 1.获取Class对象
 * 三种方式：Class.forName("完整路径")
 * 2.可以动态创建对象
 * clz.getConstructor().newInstance()
 * @author WarSpite
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        //三种方式
        //1.对象.getClass()
        Iphone iphone = new Iphone();
        Class clz = iphone.getClass();
        //2.类.class()
        clz = Iphone.class;
        //3.Class.forName("包名.类名")
        //字符串很灵活可以动态的传进
        clz = Class.forName("ServerTest01.Iphone");
        
        //创建对象
        /*Iphone iphone2 = (Iphone)clz.newInstance();
        System.out.println(iphone2);*/
        Iphone iphone2 = (Iphone)clz.getConstructor().newInstance();
        System.out.println(iphone2);
    }
}
class Iphone{
    public Iphone(){
        
    }
}
