/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest03.Cinema;

/**
 * 使用同步方法火车票
 * @author WarSpite
 */
public class Happy12306 {
    public static void main(String[] args) {
        Web12306 c = new Web12306(2,"影院");
        new Passenger(c,"浩",2).start();
        new Passenger(c,"王",1).start();
        
    }
}

//顾客
class Passenger extends Thread{
    int seats;
    public Passenger(Runnable target,String name,int seats) {
        super(target,name);
        this.seats = seats;
        
    }
    
}

//火车票网
class Web12306 implements Runnable{
    int available;//可用的位置
    String name;//名称

    public Web12306(int available, String name) {
        this.available = available;
        this.name = name;
    }
    
    public void run() {
        Passenger p = (Passenger)Thread.currentThread();
        boolean flag = this.bookTickets(p.seats);
        if(flag){
            System.out.println("出票成功"+Thread.currentThread().getName()+"-<位置为："+p.seats);

        }else{
            System.out.println("出票失败"+Thread.currentThread().getName()+"-<位置不够");
        }
        
    }
    
    //购票
    public synchronized boolean bookTickets(int seats){
        System.out.println("可用位置为："+available);
        if(seats>available){
            //如果要求的座位大于available 那就false
            return false;
        }
        available-=seats;
        return true;
    }
}