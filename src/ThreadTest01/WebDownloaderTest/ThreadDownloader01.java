/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest01.WebDownloaderTest;

/**
 *
 * @author WarSpite
 */
public class ThreadDownloader01 extends Thread{
    private String url;//远程路径
    private String name;//存储名字

    public ThreadDownloader01(String url, String name) {
        this.url = url;
        this.name = name;
    }

    
    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(url, name);
    }
    //同时进行，没有先后顺序
    public static void main(String[] args) {
        ThreadDownloader01 td1 = new ThreadDownloader01("http://pic25.nipic.com/20121205/10197997_003647426000_2.jpg","a1.jpg");
        ThreadDownloader01 td2 = new ThreadDownloader01("https://www.google.com.hk/imgres?imgurl=https%3A%2F%2Fpic1.zhimg.com%2Fv2-3b4fc7e3a1195a081d0259246c38debc_1200x500.jpg&imgrefurl=https%3A%2F%2Fzhuanlan.zhihu.com%2Fp%2F24053826&docid=-jVd_l-92_0iiM&tbnid=nUynKKOEuvoiGM%3A&vet=10ahUKEwjQ1L7ps43jAhUSd98KHWnHBGIQMwhUKAMwAw..i&w=690&h=459&hl=zh-CN&safe=strict&bih=578&biw=1049&q=%E5%9B%BE%E7%89%87&ved=0ahUKEwjQ1L7ps43jAhUSd98KHWnHBGIQMwhUKAMwAw&iact=mrc&uact=8","a2.jpg");
        ThreadDownloader01 td3 = new ThreadDownloader01("https://www.google.com.hk/imgres?imgurl=http%3A%2F%2Fpic.sc.chinaz.com%2Ffiles%2Fpic%2Fpic9%2F201610%2Fapic23847.jpg&imgrefurl=http%3A%2F%2Fsc.chinaz.com%2Ftupian%2F161114081544.htm&docid=ZU8J5fhbQ5_WbM&tbnid=UQlGh7q5Rb3piM%3A&vet=10ahUKEwjQ1L7ps43jAhUSd98KHWnHBGIQMwhbKAowCg..i&w=650&h=1015&hl=zh-CN&safe=strict&bih=578&biw=1049&q=%E5%9B%BE%E7%89%87&ved=0ahUKEwjQ1L7ps43jAhUSd98KHWnHBGIQMwhbKAowCg&iact=mrc&uact=8","a3.jpg");
        
        //启动三个线程
        td1.start();
        td2.start();
        td3.start();
    }
}
