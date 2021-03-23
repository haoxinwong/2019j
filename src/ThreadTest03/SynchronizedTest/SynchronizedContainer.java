/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest03.SynchronizedTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author WarSpite
 */
public class SynchronizedContainer {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String>list = new CopyOnWriteArrayList<String>();
        for(int i = 0;i<10000;i++){
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());
    }
}
