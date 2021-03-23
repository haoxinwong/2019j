/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search_SortTest;

import java.util.Arrays;

/**
 * 测试二分法查找（折半检索）
 * @author WarSpite
 */
public class TestBinarySearch {
    public static void main(String[]args){
        int[]arr = {30,20,50,10,80,9,7,12,100,40,8};
        //先排序
        Arrays.sort(arr);
        
        int value = 10;//要查找的值
        
        System.out.println(Arrays.toString(arr));
        System.out.println(myBinarySearch(arr,100));
        
    }
    
    public static int myBinarySearch(int[]arr,int value){
        int low = 0;
        int high = arr.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            //如果value正好等于arr[mid]，就返回mid的数字
            if(value == arr[mid]){
                return mid;
            }
            //如果value大于arr[mid],那么下一次找的时候low就是从比mid大1的位置开始
            if(value>arr[mid]){
                low = mid + 1;
            }
            //如果value小于arr[mid],那么下一次找的时候high就是从比mid小1的位置开始
            if(value<arr[mid]){
                high = mid-1;
            }
        }
        return -1;
        
    }
    
}
