/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.UDPServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 发送端：使用面向对象封装
 * @author WarSpite
 */
public class TalkSend implements Runnable{
    private DatagramSocket client;
    private BufferedReader reader; 
    private String toIP;
    private int toPort;
    public TalkSend(int port,String toIP,int toPort){
        this.toIP = toIP;
        this.toPort = toPort;
        try {
            client = new DatagramSocket(port);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException ex) {
            Logger.getLogger(TalkSend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run() {
        for(;;){
            String data;
            try {
                data = reader.readLine();
                byte [] datas = data.getBytes();
                // 3.封装成DatagramPacket包裹 需要指定目的地
                DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                        //IP地址和端口
                        new InetSocketAddress(this.toIP,this.toPort));//这里9999，另一边必须也是9999
                // 4.发送包裹send(DatagramPacket p)
                client.send(packet);
                if(data.equals("bye")){
                    break;
                }
            } catch (IOException ex) {
                Logger.getLogger(TalkSend.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        // 5.释放资源
        client.close();
    }
    
}
