/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.MyCollections.MySet;

import java.util.HashMap;

/**
 *
 * @author WarSpite
 */
public class MyHashSet01 {
    
    HashMap map;
    private static final Object PRESENT = new Object();
    
    public MyHashSet01(){
        map = new HashMap();
    }
    
    public int size(){
        return map.size();
    }
    
    public void add(Object o){
        map.put(o,PRESENT);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Object key:map.keySet()){
            sb.append(key+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }
    
    
    
    public static void main(String[]args){
        MyHashSet01 set = new MyHashSet01();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        System.out.println(set);
        
    }
}
