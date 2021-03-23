/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest04;

/**
 *
 * @author WarSpite
 */
public class Information {
    /**
     * Nadia Ali 
     * 多线程-多条路，同时
     * 创建方法-实现Runnable重写run方法，继承Thread重写run（不推荐）,实现callable接口重写call
     * 用的时候：
     * CreateThread02 ct = new CreateThread02();
     * Thread t = new Thread(ct);
     * t.start();
     * 
     * 新生->就绪->运行->阻塞->死亡
     * 
     * 停止线程
     * 1.用标志
     * 
     * 阻塞
     * 1.sleep睡觉，一般用来模拟网络延迟
     * 2.join合并线程，插队
     * 3.yield从运行到就绪，让出cpu的调度
     * 4.name，currentThread
     * 5.优先级
     * 6守护线程
     * 
     * 并发-多线程对同一份资源进行修改
     * 同步 synchronized
     * CAS原子操作 volatile
     * 同步方法，同步块，锁定对象
     * 
     * 生产者消费者模式 wait notify
     * 
     * JUC->高级工程师
     * 
     * 
     */
    
}
