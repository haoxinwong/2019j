/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.TCPTest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 模拟登入:多个客户端请求
 * 创建服务器
 * 1.使用ServerSocket创建服务器
 * 2.阻塞式等到连接accept
 * 3.操作：IO输入输出流
 * 4.释放资源
 * @author WarSpite
 */
public class LoginMultiServer {
    public static void main(String[] args) throws IOException {
        System.out.println("----Server---");
        //1.使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2.阻塞式等到连接accept
        boolean isRunning = true;
        while(isRunning){
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            new Thread(new Channel(client)).start();
        }
        //服务器一般不会关，如果要维护，那就关了
        server.close();
    }
    //一个channel就代表一个客户端
    static class Channel implements Runnable{
        private Socket client;
        //输入流,封装
        private DataInputStream dis;
        //输出流，封装
        private DataOutputStream dos;
        public Channel(Socket client){
            this.client = client;
            try {
                //输入
                dis = new DataInputStream(client.getInputStream());
                //输出
                dos = new DataOutputStream(client.getOutputStream());

            } catch (IOException ex) {
                Logger.getLogger(LoginMultiServer.class.getName()).log(Level.SEVERE, null, ex);
                release();
            }
            
        }
        //接收数据
        private String receive(){
            String datas = "";
            try {
                datas = dis.readUTF();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return datas;
        }
        //释放资源
        private void release(){
            //4.释放资源
            try {
                if(null!=dos){
                    dos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(LoginMultiServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if(null!=dis){
                    dis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(LoginMultiServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if(null!=client){
                    client.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(LoginMultiServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //发送数据
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        @Override
        public void run() {
            //3.操作：IO输入输出流
            
            String uname = "";
            String upwd = "";

            //分析
            String[] dataArray = receive().split("&");
            for(String info:dataArray){
                String[] userInfo = info.split("=");
                if(userInfo[0].equals("uname")){
                    System.out.println("你的用户名为："+userInfo[1]);
                    uname = userInfo[1];
                }else if(userInfo[0].equals("upwd")){
                    System.out.println("你的密码为："+userInfo[1]);
                    upwd = userInfo[1];
                }
            }

            //输出

            if(uname.equals("a")&&upwd.equals("b")){//成功
                send("登入成功，欢迎回来");
                
            }else{//对象
                //dos.writeUTF(uname+" "+upwd);
                send("用户名或密码错误");
                
            }
            
            release();
        }
        
        
    }
    
}
