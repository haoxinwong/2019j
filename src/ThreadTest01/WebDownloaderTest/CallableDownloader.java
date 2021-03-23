/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest01.WebDownloaderTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 了解创建线程的方式三
 * @author WarSpite
 */
public class CallableDownloader implements Callable<Boolean>{
    private String url;
    private String name;
    
    public CallableDownloader(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader wd = new WebDownloader();
        wd.download(url, name);
        System.out.println(name);
        return true;
    }
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDownloader cd1 = new CallableDownloader("http://pic25.nipic.com/20121205/10197997_003647426000_2.jpg","a1.jpg");
        CallableDownloader cd2 = new CallableDownloader("https://www.google.com.hk/imgres?imgurl=https%3A%2F%2Fpic1.zhimg.com%2Fv2-3b4fc7e3a1195a081d0259246c38debc_1200x500.jpg&imgrefurl=https%3A%2F%2Fzhuanlan.zhihu.com%2Fp%2F24053826&docid=-jVd_l-92_0iiM&tbnid=nUynKKOEuvoiGM%3A&vet=10ahUKEwjQ1L7ps43jAhUSd98KHWnHBGIQMwhUKAMwAw..i&w=690&h=459&hl=zh-CN&safe=strict&bih=578&biw=1049&q=%E5%9B%BE%E7%89%87&ved=0ahUKEwjQ1L7ps43jAhUSd98KHWnHBGIQMwhUKAMwAw&iact=mrc&uact=8","a2.jpg");
        CallableDownloader cd3 = new CallableDownloader("https://www.google.com.hk/imgres?imgurl=http%3A%2F%2Fpic.sc.chinaz.com%2Ffiles%2Fpic%2Fpic9%2F201610%2Fapic23847.jpg&imgrefurl=http%3A%2F%2Fsc.chinaz.com%2Ftupian%2F161114081544.htm&docid=ZU8J5fhbQ5_WbM&tbnid=UQlGh7q5Rb3piM%3A&vet=10ahUKEwjQ1L7ps43jAhUSd98KHWnHBGIQMwhbKAowCg..i&w=650&h=1015&hl=zh-CN&safe=strict&bih=578&biw=1049&q=%E5%9B%BE%E7%89%87&ved=0ahUKEwjQ1L7ps43jAhUSd98KHWnHBGIQMwhbKAowCg&iact=mrc&uact=8","a3.jpg");
        
        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean>result1 = ser.submit(cd1);
        Future<Boolean>result2 = ser.submit(cd2);
        Future<Boolean>result3 = ser.submit(cd3);
        //获取结果
        boolean r1 =result1.get();
        boolean r2 =result2.get();
        boolean r3 =result3.get();
        System.out.println(r3);
        //关闭服务
        ser.shutdownNow();
    }
    
}
