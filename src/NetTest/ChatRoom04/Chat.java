/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.ChatRoom04;

import NetTest.ChatRoom03.*;
import NetTest.ChatRoom02.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 在线聊天室：服务端
 * 目标：私聊
 * @author WarSpite
 */
public class Chat {
    //推荐使用CopyOnWriteArrayList
    private static CopyOnWriteArrayList<Channel>all = new CopyOnWriteArrayList<Channel>();
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-----");
        
        ServerSocket server = new ServerSocket(8888);
        while(true){
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            Channel c = new Channel(client);
            all.add(c);//管理所有的成员
            new Thread(c).start();
        }
    }
    //一个客户代表一个Channel
    static class Channel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning;
        private String name;
        public Channel(Socket client){
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                isRunning = true;
                //获取名称
               this.name = receive();
               //欢迎进入聊天室
               this.send("欢迎进入聊天室");
               sendOthers(this.name+"来到了聊天室",true);
            } catch (IOException ex) {
                System.out.println("----1");
                release();
            }
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
        
        /**
         * 群聊: 获取自己的消息，发给其他人
         * 私聊：约定数据格式：@xxx：msg
         * 
         */
        private void sendOthers(String msg,boolean isSys){
            boolean isPrivate = msg.startsWith("@");
            if(isPrivate){
                int idx = msg.indexOf(":");
                //获取目标和数据
                String targetName = msg.substring(1,idx);
                msg = msg.substring(idx+1);
                for(Channel other:all){
                    if(other.name.equals(targetName)){
                        other.send(this.name+"悄悄的对您说:"+msg);
                        break;
                    }
                }
            }else{
                for(Channel other:all){
                    if(other==this){
                        continue;
                    }
                    if(!isSys){
                        other.send(this.name+"对所有人说:"+msg);//群聊消息
                    }else{
                        other.send(msg);//系统消息
                    }
                }
            }
        }
        //释放资源
        private void release(){
            this.isRunning = false;
            Utils.close(dos,dis,client);
            //退出
            all.remove(this);
            sendOthers(this.name+"离开了聊天室",true);
        }

        @Override
        public void run() {
            while(isRunning){
                String msg = receive();
                if(!msg.equals("")){
                    //send(msg);
                    sendOthers(msg,false);
                }
            }
        }
    }
}
