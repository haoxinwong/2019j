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

/**
 * 模拟登入：双向
 * 创建服务器
 * 1.使用ServerSocket创建服务器
 * 2.阻塞式等到连接accept
 * 3.操作：IO输入输出流
 * 4.释放资源
 * @author WarSpite
 */
public class LoginTwoWayServer {
    public static void main(String[] args) throws IOException {
        System.out.println("----Server---");
        //1.使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2.阻塞式等到连接accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
        //3.操作：IO输入输出流
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String datas = dis.readUTF();
        String uname = "";
        String upwd = "";
        
        //分析
        String[] dataArray = datas.split("&");
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
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        
        if(uname.equals("a")&&upwd.equals("b")){//成功
            dos.writeUTF("登入成功，欢迎回来");
        }else{//对象
            //dos.writeUTF(uname+" "+upwd);
            dos.writeUTF("用户名或密码错误");
        }
        dos.flush();
        //4.释放资源
        dos.close();
        dis.close();
        client.close();
        
        //服务器一般不会关，如果要维护，那就关了
        //server.close();
    }
}
