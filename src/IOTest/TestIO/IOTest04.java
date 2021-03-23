/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.TestIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 文件字节输出流
 * 1.创建源
 * 2.选择流
 * 3.操作（写出内容）
 * 4.释放资源
 * @author WarSpite
 */
public class IOTest04 {
    public static void main(String[]args) {
        //创建源
        File test = new File("gg.txt");
        //选择流
        OutputStream os = null;
        try{
            //replace
            //os = new FileOutputStream(test,false);
            //追加
            os = new FileOutputStream(test,true);
            //3.操作（写出）
            String m = "IO\r\n";
            byte[]datas = m.getBytes();//字符串--->字节数组（编码）
            os.write(datas,0,datas.length);
            os.flush();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            //释放资源
            if(null!=os){
                try {
                    os.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
