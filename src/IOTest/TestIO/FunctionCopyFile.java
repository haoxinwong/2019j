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

/**
 *
 * @author WarSpite
 */
public class FunctionCopyFile {
    public static void main(String[]args){
        copy("s","s");
    }
    /**
     * 文件的拷贝
     * 思考，利用递归制作文件夹的拷贝
     * @param srcPath
     * @param desPath 
     */
    public static void copy(String srcPath,String desPath){
        File src = new File(srcPath);//源头
        File test = new File(desPath);//目的地
        
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
