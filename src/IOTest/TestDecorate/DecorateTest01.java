/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.TestDecorate;

/**
 * 实现放大器对声音的放大功能
 * 1.抽象组件：需要装饰的抽象对象（一般是接口或抽象父类）
 * 2.具体组件：需要装饰的对象（人）
 * 3.抽象装饰类：包含了对抽象组件的引用以及装饰着共有的方法
 * 4.具体装饰类：被装饰的对象
 * @author WarSpite
 */
public class DecorateTest01 {
    public static void main(String[]args){
        Person p = new Person();
        p.say();
        
        Amplifier ap = new Amplifier(p);
        ap.say();
    }
}

interface Say{
    void say();
}

class Person implements Say{
    //属性
    private int voice = 10;

    @Override
    public void say() {
        System.out.println("人的声音为："+this.getVoice());
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }
    
    
}

class Amplifier implements Say{
    
    private Person p;
    Amplifier(Person p){
        this.p = p;
    }

    @Override
    public void say() {
        System.out.println("人的声音为："+p.getVoice()*100);
        System.out.println("噪音");
        }
    
}