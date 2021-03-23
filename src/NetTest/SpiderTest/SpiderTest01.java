/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.SpiderTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网络爬虫原理
 * @author WarSpite
 */
public class SpiderTest01 {
    public static void main(String[] args) throws Exception {
        //获取URL
        //URL url = new URL("https://jd.com");
        URL url = new URL("https://dianping.com");
        //下载资源
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        String msg =null;
        while(null!=(msg=br.readLine())){
            System.out.println(msg);
        }
        br.close();
        //分析数据
        
        //处理
    }
}
