/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.TestBuffer;

import IOTest.TestIO.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

/**
 *
 * @author WarSpite
 */
public class BufferedCopyFile {
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
        //InputStream is = null;
        //OutputStream os = null;
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(src));
            BufferedWriter bw = new BufferedWriter(new FileWriter(test,true));
            //3.操作（逐行读取）
            String line =null;
            
            while((line = br.readLine())!=null){
                //逐行写出
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            
        }
    
    }
}
