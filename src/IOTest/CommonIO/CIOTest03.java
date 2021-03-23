/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.CommonIO;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import static org.apache.commons.io.FileUtils.readLines;
import org.apache.commons.io.LineIterator;

/**
 * 读取内容
 * 只要操作文件都给指定字符集
 * @author WarSpite
 */
public class CIOTest03 {
    public static void main(String[] args) throws IOException {
        //读取文件
        String msg = FileUtils.readFileToString(new File("gg.txt"),"UTF-8");
        System.out.println(msg);
        
        //文件长度
        byte[]datas = FileUtils.readFileToByteArray(new File("gg.txt"));
        System.out.println(datas.length);
        
        //逐行读取
        List<String>msgs = FileUtils.readLines(new File("gg.txt"),"UTF-8");
        for(String strings:msgs){
            System.out.println(strings);
        }
        LineIterator it = FileUtils.lineIterator(new File("gg.txt"), "UTF-8");
        while(it.hasNext()){
            System.out.println(it.nextLine());
        }
        
    }
}
