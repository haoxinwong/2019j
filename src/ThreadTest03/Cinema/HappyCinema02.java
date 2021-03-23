/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest03.Cinema;

import java.util.ArrayList;
import java.util.List;

/**
 * 快乐影院
 * @author WarSpite
 */
public class HappyCinema02 {
    public static void main(String[] args) {
        //可用的位置
        List<Integer>available = new ArrayList<Integer>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(4);
        available.add(5);

        
        //顾客需要的位置
        List<Integer>seats1 = new ArrayList<Integer>();
        seats1.add(1);
        seats1.add(2);
        
        List<Integer>seats2 = new ArrayList<Integer>();
        seats2.add(4);
        seats2.add(5);
        seats2.add(6);
        
        Cinema2 c = new Cinema2(available,"影院");
        new Thread(new Customer2(c,seats1),"浩").start();
        new Thread(new Customer2(c,seats2),"王").start();
    }
}

class Customer2 implements Runnable{
    Cinema2 cinema;
    List<Integer> seats;

    public Customer2( Cinema2 cinema,List<Integer>seats) {
        super();
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        //同步块，锁影院
        synchronized(cinema){
            boolean flag = cinema.bookTickets(seats);
            if(flag){
                System.out.println("出票成功"+Thread.currentThread().getName()+"-<位置为："+seats);

            }else{
                System.out.println("出票失败"+Thread.currentThread().getName()+"-<位置不够");
            }
        }
    }
    
}

//影院
class Cinema2{
    List<Integer> available;//可用的位置
    String name;//名称

    public Cinema2(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }
    
    //购票
    public boolean bookTickets(List<Integer> seats){
        System.out.println("可用位置为："+available);
        //先把位置拷一份
        List<Integer>copy = new ArrayList<Integer>();
        copy.addAll(available);
        
        //然后把copy移除所有seats有的元素
        copy.removeAll(seats);
        //判断大小
        //用available的大小-拷贝的大小
        //如果减去后的大小，不等于seats里面的元素
        //那就错误
        if(available.size()-copy.size()!=seats.size()){
            return false;
            
        }
        //成功的话，把copy给available
        available = copy;
        return true;
    }
}