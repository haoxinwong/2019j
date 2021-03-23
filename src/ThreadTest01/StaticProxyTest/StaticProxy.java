/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest01.StaticProxyTest;

/**
 * 静态代理
 * 都需要实现相同公共接口
 * 1.真实角色
 * 2.代理角色
 * @author WarSpite
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();
        
        //new Thread(线程对象）.start();
    }
}

interface Marry{
    void happyMarry();
}

//真实角色
class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("you and change 奔月");
    }

}

//代理角色
class WeddingCompany implements Marry{
    //真实角色
    private Marry target;
    public WeddingCompany(Marry target){
        this.target = target;
    }
    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }
    
    private void ready(){
        System.out.println("布置房间");
    }
    
    private void after(){
        System.out.println("结束");
    }
    
}