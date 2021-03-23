/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.CommonIO;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author WarSpite
 */
public class CIOTest05 {
    public static void main(String[] args) throws IOException {
        //复制文件
        //FileUtils.copyFile(new File("gg.jpg"), new File("gg-copy.jpg"));
        //复制文件到目录
        //FileUtils.copyFileToDirectory(new File("gg.jpg"), new File("lib"));
        //复制目录到目录
        //FileUtils.copyDirectoryToDirectory(new File("lib"), new File("lib2"));
        //复制目录
        //FileUtils.copyDirectory(new File("lib"), new File("lib2"));
        //拷贝URL内容
        FileUtils.copyURLToFile(new URL("http://baidu.com"), new File("baidu.txt"));
        String data = IOUtils.toString(new URL("http://www.baidu.com"),"UTF-8");
        System.out.println(data);
        data = IOUtils.toString(new URL("http://www.163.com"),"GBK");
        System.out.println(data);
    }
}
