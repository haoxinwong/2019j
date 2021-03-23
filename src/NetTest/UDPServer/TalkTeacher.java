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
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkReceive(9999,"学生")).start();//结束
        
        new Thread(new TalkSend(5555,"localhost",8888)).start();//发送
    }
}
