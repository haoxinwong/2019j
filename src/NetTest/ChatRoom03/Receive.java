/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.ChatRoom03;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 使用多线程封装接收端
 * 1.发送消息
 * 2.释放资源
 * 3.重写run
 * @author WarSpite
 */
public class Receive implements Runnable{
    private DataInputStream dis;
    private Socket client;
    private boolean isRunning;
    public Receive(Socket client){
        this.client = client;
        this.isRunning = true;
        try {
            dis= new DataInputStream(client.getInputStream());
        } catch (IOException ex) {
            System.out.println("======2");
            release();
        }
    }
    //接收消息
    private String receive(){
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException ex) {
            System.out.println("=4===");
            release();
        }
        return msg;
    }
    @Override
    public void run() {
        while(isRunning){
            String msg = receive();
            if(!msg.equals("")){
                System.out.println(msg);
            }
        }
    }
    //释放资源
    private void release(){
        this.isRunning = false;
        Utils.close(dis,client);
    }
}
