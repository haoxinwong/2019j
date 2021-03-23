/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest02;

/**
 * 其他方法
 * isAlive:线程是否还活着
 * Thread.currentThread()：当前线程
 * setName()，getName():代理名称
 * 真实名称通过面向对象的模式设计
 * @author WarSpite
 */
public class InforTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().isAlive());
        
        //设置名字：真实角色+代理角色
        MyInfo info = new MyInfo("飞机");
        Thread t = new Thread(info);
        t.setName("汽车");
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isAlive());
    }
}

class MyInfo implements Runnable{
    private String name;

    public MyInfo(String name) {
        this.name = name;
    }
    

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+name);
    }
    
}
