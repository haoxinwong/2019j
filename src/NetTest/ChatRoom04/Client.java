/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.ChatRoom04;

import NetTest.ChatRoom03.*;
import NetTest.ChatRoom02.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 在线聊天室：客户端
 * 目标：加入容器实现群聊
 * @author WarSpite
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Client-----");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //在建立连接之前先确认名称
        System.out.println("请输入用户名：");
        String name = br.readLine();
        
        Socket client = new Socket("localhost",8888);
        
        new Thread(new Send(client,name)).start();
        
        new Thread(new Receive(client)).start();
    }
}
