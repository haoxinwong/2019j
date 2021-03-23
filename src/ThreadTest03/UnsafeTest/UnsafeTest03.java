/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest03.UnsafeTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程不安全：操作容器
 * @author WarSpite
 */
public class UnsafeTest03 {
    public static void main(String[] args) {
        List<String>list = new ArrayList<String>();
        for(int i=0;i<10000;i++){
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        
        System.out.println(list.size());
    }
}
