/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadTest01.WebDownloaderTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 * 下载图片
 * @author WarSpite
 */
public class WebDownloader {
    public void download(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            System.out.println("不合法路径");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("图片加载失败");
        }
    }
}
