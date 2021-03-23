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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 在线聊天室：服务端
 * 目标：实现多个客户可以正常收发多条消息
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
            new Thread(()->{
            DataInputStream dis = null;
            DataOutputStream dos = null;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                
            } catch (IOException ex) {
                Logger.getLogger(TMultiChat.class.getName()).log(Level.SEVERE, null, ex);
            }
            //不断的发，不断的接收
            boolean isRunning = true;
            while(isRunning){
                //接收消息
                String msg;
                try {
                    msg = dis.readUTF();
                    dos.writeUTF(msg);
                    dos.flush();
                } catch (IOException ex) {
                    Logger.getLogger(TMultiChat.class.getName()).log(Level.SEVERE, null, ex);
                    isRunning = false;//停止线程
                }
                //返回消息
            }
            try {
                //释放资源
                if(null==dos){
                    dos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(TMultiChat.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                //释放资源
                if(null==dis){
                    dis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(TMultiChat.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                //释放资源
                if(null==client){
                    client.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(TMultiChat.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }).start();
        }
    }
}
