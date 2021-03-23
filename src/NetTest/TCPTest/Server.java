/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.TCPTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 熟悉流程
 * 创建服务器
 * 1.使用ServerSocket创建服务器
 * 2.阻塞式等到连接accept
 * 3.操作：IO输入输出流
 * 4.释放资源
 * @author WarSpite
 */
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("----Server---");
        //1.使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2.阻塞式等到连接accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data = dis.readUTF();
        System.out.println(data);
        
        //3.释放资源
        dis.close();
        client.close();
        
        //服务器一般不会关，如果要维护，那就关了
        //server.close();
    }
}
