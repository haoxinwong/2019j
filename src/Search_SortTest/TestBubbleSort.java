/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search_SortTest;

import java.util.Arrays;

/**
 * 测试冒泡排序
 * @author WarSpite
 */
public class TestBubbleSort {
    public static void main(String[]args){
        
        int[]values = {3,1,6,2,9,0,7,4,5,8};
        int temp = 0;
        for(int i = 0;i<values.length-1;i++){
            //设置boolean，如果整个循环如果没有发生交换，就结束
            boolean flag = true;
            for(int j = 0;j<values.length-1-i;j++){//length-1-i,减少最后一个
                //比较大小，换顺序
                if(values[j]>values[j+1]){
                    temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                    flag = false;
                }
                System.out.println(Arrays.toString(values));
            }
            if(flag){
                System.out.println("结束");
                break;
            }
            
        }
        
    }
    
}
