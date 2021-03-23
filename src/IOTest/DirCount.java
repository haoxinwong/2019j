/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest;

import java.io.File;

/**
 * 使用面向对象统计文件夹的大小
 * @author WarSpite
 */
public class DirCount {
    
    //大小
    private long len;
    //文件夹
    private String path;
    //文件的个数
    private int fileSize;
    //文件夹的个数-如果不想包含自己，就从-1开始
    private int dirSize;
    //源
    private File src;
    
    public DirCount(String path){
        this.path = path;
        this.src = new File(path);
        count(this.src);
    }
    
    public static void main(String[]args){
        DirCount dir = new DirCount("C:\\\\NetBeans");
        System.out.println(dir.getLen()+"----"+dir.getDirSize()+"-----"+dir.getFileSize());
       
    }
    //统计大小
    private void count(File src){
        //获取大小
        if(null!=src&&src.exists()){
            if(src.isFile()){
                len+=src.length();
                this.fileSize++;
            }else{
                this.dirSize++;
                for(File s:src.listFiles()){
                    count(s);
                }
            }
        }
    }

    public long getLen() {
        return len;
    }

    public int getFileSize() {
        return fileSize;
    }

    public int getDirSize() {
        return dirSize;
    }
    
    
    
    
    
    
}
