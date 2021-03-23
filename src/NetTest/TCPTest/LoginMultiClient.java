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
import static java.lang.System.console;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 模拟登入：双向
 * 创建客户器
 * 1.建立连接：使用Socket创建服务器+服务的地址和端口
 * 2.操作：IO输入输出流
 * 3.释放资源
 * @author WarSpite
 */
public class LoginMultiClient {
    public static void main(String[] args) throws IOException {
        //1.建立连接：使用Socket创建服务器+服务的地址和端口
        Socket client = new Socket("localhost",8888);
        //2.操作：IO输入输出流 先请求后响应
        new Send(client).send();
        new Receive(client).receive();
        client.close();
        
        
    }
    //发送
    static class Send{
        private Socket client;
        private DataOutputStream dos;
        private BufferedReader console;
        private String msg;
        public Send(Socket client){
            this.client = client;
            console = new BufferedReader(new InputStreamReader(System.in));
            this.msg = init();
            try {
                dos= new DataOutputStream(client.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(LoginMultiClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        private String init(){
            try {
                System.out.print("请输入用户名：");
                String uname = console.readLine();
                System.out.print("请输入密码：");
                String upwd = console.readLine();
                return "uname="+uname+"&"+"upwd="+upwd;
            } catch (IOException ex) {
                Logger.getLogger(LoginMultiClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "";
        }
        public void send(){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException ex) {
                Logger.getLogger(LoginMultiClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //接收
    static class Receive{
        private Socket client;
        private DataInputStream dis;
        public Receive(Socket client){
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(LoginMultiClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void receive(){
            String result;
            try {
                result = dis.readUTF();
                System.out.println(result);
            } catch (IOException ex) {
                Logger.getLogger(LoginMultiClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
