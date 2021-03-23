/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.CommonIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 * 写出内容
 * @author WarSpite
 */
public class CIOTest04 {
    public static void main(String[] args) throws IOException {
        //写出内容,两个一样的
        FileUtils.write(new File("gg.txt"),"草","UTF-8",true);
        FileUtils.writeStringToFile(new File("gg.txt"),"纳尼\r\n","UTF-8",true);
        
        FileUtils.writeByteArrayToFile(new File("gg.txt"), "妈蛋".getBytes("UTF-8"),true);
        
        //写出列表
        List<String>datas = new ArrayList<String>();
        datas.add("风1");
        datas.add("风2");
        datas.add("风3");
        FileUtils.writeLines(new File("gg.txt"), datas,"UTF-8",true);
        
    }
}
