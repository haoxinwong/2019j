/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.ChatRoom02;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 在线聊天室：客户端
 * 目标：实现多个客户可以正常收发多条消息
 * @author WarSpite
 */
public class TMultiClient {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Client-----");
        Socket client = new Socket("localhost",8888);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        boolean isRunning = true;
        while(isRunning){
            //客户端发送消息
            String msg = console.readLine();
            dos.writeUTF(msg);
            dos.flush();
            //获取消息
            msg = dis.readUTF();
            System.out.println(msg);
        }
        dos.close();
        dis.close();
        client.close();
    }
}
