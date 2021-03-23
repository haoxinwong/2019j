/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.TCPTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 上传文件
 * 创建客户器
 * 1.建立连接：使用Socket创建服务器+服务的地址和端口
 * 2.操作：IO输入输出流
 * 3.释放资源
 * @author WarSpite
 */
public class FileClient {
    public static void main(String[] args) throws IOException {
        System.out.println("----Client----");
        //1.建立连接：使用Socket创建服务器+服务的地址和端口
        Socket client = new Socket("localhost",8888);
        //2.操作：拷贝
        InputStream is = new BufferedInputStream(new FileInputStream("a1.jpg"));
        OutputStream os = new BufferedOutputStream(client.getOutputStream());
        byte[]flush = new byte[1024];
        int len = -1;
        while((len = is.read(flush))!=-1){
            os.write(flush,0,len);
        }
        os.flush();
        //3.释放资源
        os.close();
        is.close();
        client.close();
        
        
    }
}
