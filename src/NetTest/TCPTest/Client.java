/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.TCPTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 熟悉流程
 * 创建客户器
 * 1.建立连接：使用Socket创建服务器+服务的地址和端口
 * 2.操作：IO输入输出流
 * 3.释放资源
 * @author WarSpite
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("----Client----");
        //1.建立连接：使用Socket创建服务器+服务的地址和端口
        Socket client = new Socket("localhost",8888);
        //2.操作：IO输入输出流
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String data = "hello";
        dos.writeUTF(data);
        dos.flush();
        //3.释放资源
        dos.close();
        client.close();
        
        
    }
}
