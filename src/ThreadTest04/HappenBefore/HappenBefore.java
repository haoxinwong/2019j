/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest04.HappenBefore;

/**
 * 指令重排，代码执行顺序与预期不一致
 * @author WarSpite
 */
public class HappenBefore {
    //变量1
    private static int a = 0;
    //变量2
    private static boolean flag = false;
    
    public static void main(String[] args) throws InterruptedException {
        //线程1 读取数据
        for(int i=0;i<10;i++){
            a = 0;
            flag = false;
            Thread t1 = new Thread(()->{
                a = 1;
                flag = true;
            });
            //线程2 更改数据
            Thread t2 = new Thread(()->{
                if(flag){
                    a*=1;
                }
                //指令重排
                if(a==0){
                    System.out.println("HappenBefore a->"+a);
                }
            });

            t1.start();
            t2.start();
            //合并线程
            t1.join();
            t2.join();
        }
    }
}
