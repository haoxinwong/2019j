/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.CommonIO;

import java.io.File;
import java.util.Collection;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * 列出子孙级
 * @author WarSpite
 */
public class CIOTest02 {
    public static void main(String[] args) {
        Collection<File>files = FileUtils.listFiles(new File("C:/NetBeans"), EmptyFileFilter.NOT_EMPTY, null);
        for(File file:files){
            System.out.println(file.getAbsolutePath());
        }
        
        System.out.println("---------");
        //DirectoryFileFilter.INSTANCE - 表示操作子孙级
        files = FileUtils.listFiles(new File("C:/NetBeans"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
        for(File file:files){
            System.out.println(file.getAbsolutePath());
        }
        
        System.out.println("---------");
        //new SuffixFileFilter("java") - 表示只要后缀是java的
        files = FileUtils.listFiles(new File("C:/NetBeans"), new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
        for(File file:files){
            System.out.println(file.getAbsolutePath());
        }
        
        System.out.println("---------");
        //FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class"))
        //- 表示只要后缀是java或class的
        files = FileUtils.listFiles(new File("C:/NetBeans"), 
                FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class")), DirectoryFileFilter.INSTANCE);
        for(File file:files){
            System.out.println(file.getAbsolutePath());
        }
        
        System.out.println("---------");
        //FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class"),EmptyFileFilter.EMPTY)
        //- 表示只要后缀是java或class或空文件的
        files = FileUtils.listFiles(new File("C:/NetBeans"), 
                FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class"),EmptyFileFilter.EMPTY), DirectoryFileFilter.INSTANCE);
        for(File file:files){
            System.out.println(file.getAbsolutePath());
        }
        
        System.out.println("---------");
        //FileFilterUtils.and(new SuffixFileFilter("java"),EmptyFileFilter.NOT_EMPTY)
        //- 表示只要后缀是java并且不是空文件的
        files = FileUtils.listFiles(new File("C:/NetBeans"), 
                FileFilterUtils.and(new SuffixFileFilter("java"),EmptyFileFilter.NOT_EMPTY), DirectoryFileFilter.INSTANCE);
        for(File file:files){
            System.out.println(file.getAbsolutePath());
        }
        
    }
}
