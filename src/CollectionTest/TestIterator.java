/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 测试迭代器遍历List，Set，Map
 * @author WarSpite
 */
public class TestIterator {
    public static void main(String[]args){
        //testIteratorList();
        //testIteratorSet();
        testIteratorMap();
    }
    
    public static void testIteratorList(){
        List<String> list = new ArrayList<>(3);
        
        list.add("aa");
        list.add("bb");
        list.add("cc");
        
        //Iterator iter;
        //使用iterator 遍历List
        for(Iterator<String>iter = list.iterator();iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }
    
    public static void testIteratorSet(){
        Set<String> set = new HashSet<>(3);
        
        set.add("aa");
        set.add("bb");
        set.add("cc");
        
        //Iterator iter;
        //使用iterator 遍历Set
        for(Iterator<String>iter = set.iterator();iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }
    
    public static void testIteratorMap(){
        Map<Integer,String> map = new HashMap<>(3);
        
        map.put(1,"aa");
        map.put(2,"bb");
        map.put(3,"cc");
        
        //第一种遍历Map的方式
        Set<Entry<Integer, String>> ss = map.entrySet();
        for(Iterator<Entry<Integer, String>>iter = ss.iterator();iter.hasNext();){
            Entry<Integer,String>temp = iter.next();
            
            System.out.println(temp.getKey()+"--"+temp.getValue());
            
        }
        
        System.out.println("*********************************");
        //第二种遍历Map的方式
        Set<Integer>keySet = map.keySet();
        for(Iterator<Integer> iter = keySet.iterator();iter.hasNext();){
            Integer key = iter.next();
            System.out.println(key+"----"+map.get(key));
        }
    }
}
