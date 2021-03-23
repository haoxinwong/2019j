/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.IPTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP：定位一个节点：计算机，路由，通讯设备
 * InetAddress:多个静态方法
 * 1.getLocalHost:本机
 * 2.getByName：根据域名DNS||IP地址-->IP
 * 
 * 两个成员方法
 * 1.getHostAddress：返回地址
 * 2.getHostName:返回计算机名
 * @author WarSpite
 */
public class IPTest01 {
    public static void main(String[] args) throws UnknownHostException {
        //使用getLocalHost方法创建InetAddress对象
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());//返回192.168.0.137
        System.out.println(addr.getHostName());//输出计算机名
        
        //根据域名得到InetAddress对象
        addr = InetAddress.getByName("www.163.com");
        System.out.println(addr.getHostAddress());//返回163服务器的IP地址
        System.out.println(addr.getHostName());//输出：www.163.com
        
        //根据ip得到InetAddress对象
        addr = InetAddress.getByName("61.135.253.15");
        System.out.println(addr.getHostAddress());//返回163服务器的IP地址
        System.out.println(addr.getHostName());//输出ip而不是域名
    }
}
