/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.UDPServer;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Date;

/**
 * 引用类型：发送端
 * 1.使用DatagramSocket指定端口 创建接收端
 * 2.将基本类型 转成字节数组
 * 3.封装成DatagramPacket包裹 需要指定目的地
 * 4.发送包裹send(DatagramPacket p)
 * 5.释放资源
 * @author WarSpite
 */
public class UDPObjCilent {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中");
        // 1.使用DatagramSocket指定端口 创建接收端
        DatagramSocket client = new DatagramSocket(8888);
        // 2.准备数据一定要转成字节数组
        //写出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
        //操作数据类型+数据
        oos.writeUTF("浩");
        oos.writeInt(18);
        oos.writeBoolean(false);
        oos.writeChar('a');
        //还支持对象
        oos.writeObject("解");//String 实现serializable可以序列化
        oos.writeObject(new Date());//date也实现serializable
        Employee emp = new Employee("马云",400);
        oos.writeObject(emp);
        oos.flush();
        
        byte []datas = baos.toByteArray();
        // 3.封装成DatagramPacket包裹 需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",9999));
        // 4.发送包裹send(DatagramPacket p)
        client.send(packet);
        // 5.释放资源
        client.close();
    }
            
}
