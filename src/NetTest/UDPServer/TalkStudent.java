/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.UDPServer;

/**
 * 加入多线程，实现双向交流 模拟在线咨询
 * @author WarSpite
 */
public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend(7777,"localhost",9999)).start();//发送
        
        new Thread(new TalkReceive(8888,"老师")).start();//学生接收
    }
}
