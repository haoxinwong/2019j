/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest04.CooperationTest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 协作模型：生产者消费者实现方式一：管程法
 * 借助缓冲区
 * @author WarSpite
 */
public class CoTest01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Productor extends Thread{
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }
    @Override
    public void run(){
        //开始生产
        for(int i = 0;i<10;i++){
            System.out.println("生产-->"+i+"个馒头");
            container.push(new Steamedbun(i));
        }
    }
}

//消费者
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }
    
    @Override
    public void run(){
        //开始消费
        for(int i = 0;i<10;i++){
            System.out.println("消费-->"+container.pop().id+"个馒头");
            container.push(new Steamedbun(i));
        }
    }
}

//缓冲区
class SynContainer{
    Steamedbun[]buns = new Steamedbun[10];//存储数据容器
    int count = 0;//计数器
    //存储 - 生产
    public synchronized void push(Steamedbun bun){
        //何时能生产 容器存在空间
        //不能生产 只有等待
        if(count == buns.length){
            try {
                this.wait();//线程阻塞 消费者通知生产解除
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        //存在数据，可以通知消费了
        this.notify();
        //存在空间可以生产
        buns[count] = bun;
        count++;
        
    }
    
    //获取 - 消费
    public synchronized Steamedbun pop(){
        //何时消费 容器中是否存在数据
        //没有数据 只有等待
        if(count ==0 ){
            try {
                this.wait();//线程阻塞 生产者通知消费就可以接触
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        //存在数据可以消费
        this.notify();//存在空间了，可以唤醒对方生产了
        count--;
        Steamedbun bun = buns[count];
        
        return bun;
    }
}

//馒头（数据）
class Steamedbun{
    int id;

    public Steamedbun(int id) {
        this.id = id;
    }
    
}
