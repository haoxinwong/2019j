/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.ChatRoom02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务端
 * 目标：实现多个客户可以正常收发多条消息
 * 问题其他客户必须等待之前的客户推出，才能继续排队
 * @author WarSpite
 */
public class MultiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-----");
        
        ServerSocket server = new ServerSocket(8888);
        while(true){
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            //不断的发，不断的接收
            boolean isRunning = true;
            while(isRunning){
                //接收消息
                String msg = dis.readUTF();
                //返回消息
                dos.writeUTF(msg);
                dos.flush();
            }
        //释放资源
        dos.close();
        dis.close();
        client.close();
        }
    }
}
