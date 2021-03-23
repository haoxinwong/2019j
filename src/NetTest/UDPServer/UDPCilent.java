/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.UDPServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 基本流程
 * 发送端
 * 1.使用DatagramSocket指定端口 创建接收端
 * 2.准备数据一定要转成字节数组
 * 3.封装成DatagramPacket包裹 需要指定目的地
 * 4.发送包裹send(DatagramPacket p)
 * 5.释放资源
 * @author WarSpite
 */
public class UDPCilent {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中");
        // 1.使用DatagramSocket指定端口 创建接收端
        DatagramSocket client = new DatagramSocket(8888);
        // 2.准备数据一定要转成字节数组
        String data = "浩王";
        byte [] datas = data.getBytes();
        // 3.封装成DatagramPacket包裹 需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                //IP地址和端口
                new InetSocketAddress("localhost",9999));//这里9999，另一边必须也是9999
        // 4.发送包裹send(DatagramPacket p)
        client.send(packet);
        // 5.释放资源
        client.close();
    }
            
}
