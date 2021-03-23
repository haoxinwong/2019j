/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.UDPServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 接收端：使用面向对象封装
 * @author WarSpite
 */
public class TalkReceive implements Runnable{
    private DatagramSocket server;
    private String from;
    public TalkReceive(int port,String from){
        this.from = from;
        try {
            this.server = new DatagramSocket(port);
        } catch (SocketException ex) {
            Logger.getLogger(TalkReceive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run() {
        for(;;){
            // 2.准备容器封装成DatagramPacket包裹
            byte[]container = new byte[1024*60];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            try {
                // 3.阻塞式接收包裹receive（DatagramPacket p)
                server.receive(packet);//阻塞式
                // 4.分析数据
                //   byte[] getData()
                //          getLength()
                byte[]datas = packet.getData();
                int len = packet.getLength();
                String data = new String(datas,0,len+1,"GBK");
                System.out.println(this.from+": "+data);
                if(data.equals("bye")){
                    break;
                }
            } catch (IOException ex) {
                Logger.getLogger(TalkReceive.class.getName()).log(Level.SEVERE, null, ex);
            }
             
         }
    }
    
}
