/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.TestIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 文件拷贝
 * @author WarSpite
 */
public class CopyFile {
    public static void main(String[]args) {
        //创建源
        File src = new File("gg.txt");//源头
        File test = new File("io.txt");//目的地
        //选择流
        InputStream is = null;
        OutputStream os = null;
        
        try{
            is = new FileInputStream(src);
            os = new FileOutputStream(test,true);
            //3.操作（分段读取）
            byte[]flush = new byte[1024];//缓冲容器
            int len = -1;//接受长度
            while((len = is.read(flush))!=-1){
                //字节数组-->字符串（解码）
                os.write(flush,0,len);
            }
            os.flush();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            //释放资源 分别关闭，先打开的后关闭
            if(null!=os){
                try {
                    os.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            try {
                if(null!=is){
                    is.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
