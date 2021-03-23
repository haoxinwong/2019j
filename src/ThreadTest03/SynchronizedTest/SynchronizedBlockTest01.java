/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest03.SynchronizedTest;

import ThreadTest03.UnsafeTest.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 线程安全：操作容器
 * @author WarSpite
 */
public class SynchronizedBlockTest01 {
    public static void main(String[] args) throws InterruptedException {
        List<String>list = new ArrayList<String>();
        for(int i=0;i<10000;i++){
            new Thread(()->{
                //同步块
                synchronized(list){
                list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(10000);
        System.out.println(list.size());
    }
}
