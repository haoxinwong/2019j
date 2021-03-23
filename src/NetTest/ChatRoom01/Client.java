/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.ChatRoom01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 在线聊天室：客户端
 * 目标：实现一个客户可以正常收发消息
 * @author WarSpite
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Client-----");
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Socket client = new Socket("localhost",8888);
        //客户端发送消息
        String msg = console.readLine();
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(msg);
        dos.flush();
        //获取消息
        DataInputStream dis = new DataInputStream(client.getInputStream());
        msg = dis.readUTF();
        System.out.println(msg);
        
        dos.close();
        dis.close();
        client.close();
    }
}
