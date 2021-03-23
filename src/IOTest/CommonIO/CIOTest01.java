/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.CommonIO;

import java.io.File;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author WarSpite
 */
public class CIOTest01 {
    public static void main(String[] args) {
        //文件大小
        long len = FileUtils.sizeOf(new File("gg.txt"));
        System.out.println(len);
        //目录大小
        len = FileUtils.sizeOf(new File("C:/NetBeans"));
        System.out.println(len);
    }
}
