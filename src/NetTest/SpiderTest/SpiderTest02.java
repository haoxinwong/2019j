/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.SpiderTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 网络爬虫原理+模拟浏览器
 * @author WarSpite
 */
public class SpiderTest02 {
    public static void main(String[] args) throws Exception {
        //获取URL
        URL url = new URL("https://dianping.com");
        //下载资源
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.26 Safari/537.36");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        String msg =null;
        while(null!=(msg=br.readLine())){
            System.out.println(msg);
        }
        br.close();
        //分析数据
        
        //处理
    }
}
