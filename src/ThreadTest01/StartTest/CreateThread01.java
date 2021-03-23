/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest01.StartTest;

/**
 * 创建线程方式一：
 * 1.创建：继承Thread+重写Run
 * 2.启动：创建子类对象+start
 * @author WarSpite
 */
public class CreateThread01 extends Thread{
    /**
     * 少用继承，多用实现
     * 少用继承Thread类，多用实现Runnable接口
     * 线程分两类，用户线程，守护线程
     */
    
    
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println("一边听歌");
            
        }
        
    }

    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            System.out.println("一边coding");
            
        }
        //创建子类对象
        CreateThread01 st = new CreateThread01();
        //启动
        //st.start();//不保证立即运行，cpu调用，开启一个新线程他走他的，你走你的
        st.run();//普通方法调用
        
        /*
        st.start()
        执行线程必须调用start()加入到调度器中
        不一定立即执行，系统安排调度分配执行
        直接调用run()不是开启多线程，是普通方法调用
        */
    }
}
