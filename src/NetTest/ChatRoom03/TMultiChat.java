/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.ChatRoom03;

import NetTest.ChatRoom02.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 在线聊天室：服务端
 * 目标：封装实现多个客户可以正常收发多条消息
 * 问题：
 * 代码不好维护，
 * 客户端读写没有分开，必须先写后读
 * @author WarSpite
 */
public class TMultiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-----");
        
        ServerSocket server = new ServerSocket(8888);
        while(true){
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            new Thread(new Channel(client)).start();
        }
    }
    //一个客户代表一个Channel
    static class Channel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning;
        public Channel(Socket client){
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                isRunning = true;
            } catch (IOException ex) {
                System.out.println("----1");
                release();
            }
        }
        //接收消息
        private String receive(){
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException ex) {
                System.out.println("-2--");
                release();
            }
            return msg;
        }
        //发送消息
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException ex) {
                System.out.println("----3--");
                release();
            }
        }
        //释放资源
        private void release(){
            this.isRunning = false;
            Utils.close(dos,dis,client);
        }

        @Override
        public void run() {
            while(isRunning){
                String msg = receive();
                if(!msg.equals("")){
                    send(msg);
                }
            }
        }
    }
}
