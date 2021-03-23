/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.TestIO;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 字节数组输出流 ByteArrayOutputStream
 * 1.创建源：内部维护
 * 2.选择流：不关联源
 * 3.操作写出内容
 * 4.释放资源：可以不用
 * 
 * 获取数据：toByteArray()
 * @author WarSpite
 */
public class IOTest08 {
    public static void main(String[]args){
        //1.创建源
        byte[]dest = null;
        //2.选择流 - 因为要使用新增方法，
        ByteArrayOutputStream baos = null;
        try{
            baos = new ByteArrayOutputStream();
            //3.操作
            String msg = "show";
            byte[]datas = msg.getBytes();//字符串-->字节数组
            baos.write(datas,0,datas.length);
            baos.flush();
            //获取数据
            dest = baos.toByteArray();
            System.out.println(dest.length+"-->"+new String(dest,0,baos.size()));
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            if(null!= baos){
                try {
                    baos.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
