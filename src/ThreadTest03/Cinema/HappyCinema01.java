/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest03.Cinema;

/**
 * 快乐影院
 * @author WarSpite
 */
public class HappyCinema01 {
    public static void main(String[] args) {
        Cinema c = new Cinema(2,"影院");
        new Thread(new Customer(c,2),"浩").start();
        new Thread(new Customer(c,1),"王").start();
    }
}

class Customer implements Runnable{
    Cinema cinema;
    int seats;

    public Customer(Cinema cinema, int seats) {
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
class Cinema{
    int available;//可用的位置
    String name;//名称

    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }
    
    //购票
    public boolean bookTickets(int seats){
        System.out.println("可用位置为："+available);
        if(seats>available){
            //如果要求的座位大于available 那就false
            return false;
        }
        available-=seats;
        return true;
    }
}