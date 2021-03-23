/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.ChatRoom04;

import NetTest.ChatRoom03.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 使用多线程封装发送端
 * 1.发送消息
 * 2.从控制台获取消息
 * 3.释放资源
 * 4.重写run
 * @author WarSpite
 */
public class Send implements Runnable{
    private BufferedReader console;
    private DataOutputStream dos;
    private Socket client;
    private boolean isRunning;
    private String name;
    public Send(Socket client,String name){
        this.client = client;
        this.isRunning = true;
        this.name = name;
        console = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(client.getOutputStream());
            //发送名称
            send(name);
        } catch (IOException ex) {
            System.out.println("===1");
            this.release();
        }
    }
    @Override
    public void run() {
        while(isRunning){
            String msg = getStrFromConsole();
            if(!msg.equals("")){
                send(msg);
            }
        }
    }
    //发送消息
    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException ex) {
            System.out.println("====3");
            release();
        }
    }
    /**
     * 从控制台获取消息
     * @return 
     */
    private String getStrFromConsole(){
        try {
            return console.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    //释放资源
    private void release(){
        this.isRunning = false;
        Utils.close(dos,client);
    }
}
