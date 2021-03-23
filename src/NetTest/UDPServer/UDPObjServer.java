/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.UDPServer;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

/**
 * 引用类型：接收端
 * Address alreadyin use:Cannot bind 同一个协议下端口不允许冲突
 * 1.使用DatagramSocket指定端口 创建接收端
 * 2.准备容器封装成DatagramPacket包裹
 * 3.阻塞式接收包裹receive（DatagramPacket p)
 * 4.分析数据 将字节数组还原为对应的基本类型
 *   byte[] getData()
 *          getLength()
 * 5.释放资源
 * @author WarSpite
 */
public class UDPObjServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中");
         // 1.使用DatagramSocket指定端口 创建接收端
         DatagramSocket server = new DatagramSocket(9999);
         // 2.准备容器封装成DatagramPacket包裹
         byte[]container = new byte[1024*60*60];
         DatagramPacket packet = new DatagramPacket(container,0,container.length);
         // 3.阻塞式接收包裹receive（DatagramPacket p)
         server.receive(packet);//阻塞式
         // 4.分析数据
         //   byte[] getData()
         //          getLength()
         byte[]datas = packet.getData();
         int len = packet.getLength();
         
         //读取-->反序列化
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //顺序与写出一致
        String msg = ois.readUTF();
        int age = ois.readInt();
        boolean flag = ois.readBoolean();
        char ch = ois.readChar();
        System.out.println(flag);
        //对象的数据还原
        Object str = ois.readObject();
        Object date = ois.readObject();
        Object employee = ois.readObject();
        
        if(str instanceof String){
            String strObj = (String)str;
            System.out.println(strObj);
        }
        if(date instanceof Date){
            Date dateObj = (Date)date;
            System.out.println(dateObj);
        }
        if(employee instanceof Employee){
            Employee employeeObj = (Employee)employee;
            System.out.println(employeeObj.getName()+"--->"+employeeObj.getSalary());
        }
         
        // 5.释放资源
         server.close();
    }
}
