/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.SetTest;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet 就是简化版的HashMap
 * 测试HashSet的基本用法
 * @author WarSpite
 */
public class TestHashSet {
    public static void main(String[]args){
        Set<String> set1 = new HashSet<>();
        
        set1.add("aa");
        set1.add("bb");
        set1.add("aa");
        System.out.println(set1);
        set1.remove("bb");
        System.out.println(set1);
        
        Set<String> set2 = new HashSet<>();
        set2.add("hao");
        set2.addAll(set1);
        System.out.println(set2);
        
    }
}
