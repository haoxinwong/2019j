/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.ChatRoom03;

import NetTest.ChatRoom02.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 在线聊天室：客户端
 * 目标：封装实现多个客户可以正常收发多条消息
 * @author WarSpite
 */
public class TMultiClient {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Client-----");
        Socket client = new Socket("localhost",8888);
        
        new Thread(new Send(client)).start();
        
        new Thread(new Receive(client)).start();
    }
}
