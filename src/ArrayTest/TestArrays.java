/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayTest;

import java.util.Arrays;

/**
 *
 * @author WarSpite
 */
public class TestArrays {
    public static void main(String[]args){
        int[]a = {10,20,30,120,80};
        System.out.println(a);
        //打印Arrays里面的内容
        System.out.println(Arrays.toString(a));
        //sort
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        //查找里面的元素，如果找到返回索引，如果没找到返回-1
        System.out.println(Arrays.binarySearch(a, 30));
        
    }
    
}
