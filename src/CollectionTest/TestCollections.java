/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections辅助类的使用
 * Collection是接口，Collections是工具类
 * @author WarSpite
 */
public class TestCollections {
    public static void main(String[] args) {
        List<String> aList = new ArrayList<String>();
        for (int i = 0; i < 5; i++){
            aList.add("a" + i);
        }
        System.out.println(aList); 
        Collections.shuffle(aList); // 随机排列list中的元素
        
        System.out.println(aList);
        Collections.reverse(aList); // 逆序排列
        
        System.out.println(aList);
        Collections.sort(aList); // 按照递增的方式排序。自定义的类使用Comparable接口
        
        System.out.println(aList);
        System.out.println(Collections.binarySearch(aList, "a2")); //二分法查找
        Collections.fill(aList, "hello");
        System.out.println(aList);
    }
    
}
