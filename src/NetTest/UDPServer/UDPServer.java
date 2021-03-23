/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.UDPServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端
 * Address alreadyin use:Cannot bind 同一个协议下端口不允许冲突
 * 1.使用DatagramSocket指定端口 创建接收端
 * 2.准备容器封装成DatagramPacket包裹
 * 3.阻塞式接收包裹receive（DatagramPacket p)
 * 4.分析数据
 *   byte[] getData()
 *          getLength()
 * 5.释放资源
 * @author WarSpite
 */
public class UDPServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中");
         // 1.使用DatagramSocket指定端口 创建接收端
         DatagramSocket server = new DatagramSocket(9999);//端口不要冲突，不然发不出来
         // 2.准备容器封装成DatagramPacket包裹
         byte[]container = new byte[1024*60];
         DatagramPacket packet = new DatagramPacket(container,0,container.length);
         // 3.阻塞式接收包裹receive（DatagramPacket p)
         server.receive(packet);//阻塞式
         // 4.分析数据
         //   byte[] getData()
         //          getLength()
         byte[]datas = packet.getData();
         int len = packet.getLength();
         System.out.println(new String(datas,0,len)+len);
         // 5.释放资源
         server.close();
    }
}
