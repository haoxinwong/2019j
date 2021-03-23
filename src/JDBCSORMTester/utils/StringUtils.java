/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCSORMTester.utils;

/**
 * 封装了字符串常用的操作
 * @author WarSpite
 */
public class StringUtils {
    /**
     * 将目标字符串首字母变成大写
     * @param str
     * @return 
     */
    public static String firstChar2UpperCase(String str){
        //abcd-->Abcd
        return str.toUpperCase().substring(0,1)+str.substring(1);
    }
}
