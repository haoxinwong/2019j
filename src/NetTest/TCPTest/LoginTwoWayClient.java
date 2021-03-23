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

/**
 * 模拟登入：双向
 * 创建客户器
 * 1.建立连接：使用Socket创建服务器+服务的地址和端口
 * 2.操作：IO输入输出流
 * 3.释放资源
 * @author WarSpite
 */
public class LoginTwoWayClient {
    public static void main(String[] args) throws IOException {
        System.out.println("----Client----");
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入用户名：");
        String uname = console.readLine();
        System.out.print("请输入密码：");
        String upwd = console.readLine();
        
        //1.建立连接：使用Socket创建服务器+服务的地址和端口
        Socket client = new Socket("localhost",8888);
        //2.操作：IO输入输出流
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("uname="+uname+"&"+"upwd="+upwd);
        dos.flush();
        
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String result = dis.readUTF();
        System.out.println(result);
        //3.释放资源
        dos.close();
        client.close();
        
        
    }
}
