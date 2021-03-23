/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest;

/**
 *
 * @author WarSpite
 */
public class Information {
    /**
     * IP用于定位节点
     * 端口port定位软件
     * 多资源软件用URL定位
     * URI - Universal Resource Identifier
     * URL - Universal Resource Locator
     * 网络三大基石：html,http,url
     * 
     * TCP(transfer control protocol)
     * 一种面向连接（连接导向）的，可靠的，基于字节流的运输层（Transport layer）通信协议
     * 特点：面向连接，点到点的通信，高可靠性，占用系统资源多，效率低
     * 
     * UDP(User Datagram Protocol)
     * 一种无连接的传输层协议，提供面向失误的简单不可靠信息传送服务
     * 特点：非面向连接，传输不可靠，可能丢失
     * 发送不管对方是否准备好，接收方受到也不确认
     * 可以广播发送，
     * 非常简单的协议，开销小，快
     * 数据不要太大，
     * 
     * 传输层往应用层发送数据，用套接字（Socket）
     * 套接字就像是传输层为应用层开的一个小口
     * 
     * TCP的Socket编程-通信双方需要建立连接-存在主次之分（114查号台）
     * UDP的Socket编程-通信双方不需要建立连接-通信双方完全平等（QQ聊天）
     * 
     * 只要能转成字节数组，都能用UDP来传输，内容不能太大
     * 
     * UDP底层使用数据包，TCP用IO
     * 
     * TCP编程：
     *    单向：客户端向服务器端发送字符串，服务器获取字符串并输出
     *    双向：服务器端给出客户端反馈，客户端得到反馈结果并输出
     *    文件：客户端向服务器端上传文件，服务器端获取文件并反馈结果
     *    多线程：服务器接收多个客户端的请求，并给出反馈，每个客户请求开启一个线程
     * 
     */
    
}
