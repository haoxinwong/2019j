/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.MapTest;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试HaspMap的使用
 * @author WarSpite
 */
public class TestHashMap {
    public static void main(String[]args){
        
        Map<Integer,String> m1 = new HashMap<>();
        
        m1.put(1,"one");
        m1.put(2,"two");
        m1.put(3,"three");
        
        System.out.println(m1.get(1));
        
        System.out.println(m1.size());
        System.out.println(m1.isEmpty());
        System.out.println(m1.containsKey(2));
        System.out.println(m1.containsValue("four"));
        
        Map<Integer,String>m2 = new HashMap<>();
        m2.put(4, "four");
        m2.put(5, "five");
        m1.putAll(m2);
        
        System.out.println(m1);
        
        //map中键不能重复，如果重复（是否重复是根据equals方法来判断），则新的覆盖旧的
        m1.put(3, "三");
        System.out.println(m1);
    }
    
}
