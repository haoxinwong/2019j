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
 *
 * @author WarSpite
 */
public class SummaryTraversal {
    public static void main(String[]args){
        
    }
    
    //普通for循环
    public static void listWay1(){
        List<String> list = new ArrayList<>(3);
        
        for(int i=0;i<list.size();i++){//list为集合的对象名
            String temp = (String)list.get(i);
            System.out.println(temp);
        }
    }
    
    //增强for循环
    public static void listWay2(){
        List<String> list = new ArrayList<>(3);
        
        for (String temp : list) {
            System.out.println(temp);
        }
    }
    
    //使用Iterator迭代器(1)
    public static void listWay3(){
        List<String> list = new ArrayList<>(3);

        for(Iterator iter= list.iterator();iter.hasNext();){
            String temp = (String)iter.next();
            System.out.println(temp);
        }
    }
    
    //使用Iterator迭代器(2)
    public static void listWay4(){
        List<String> list = new ArrayList<>(3);
        
        Iterator  iter =list.iterator();
        while(iter.hasNext()){
            Object  obj =  iter.next();
            iter.remove();//如果要遍历时，删除集合中的元素，建议使用这种方式！
            System.out.println(obj);
        }
    }
    
    //增强for循环
    public static void setWay1(){
        Set<String> set = new HashSet<>(3);
        
        for(String temp:set){
            System.out.println(temp);
        }
    }
    
    //使用Iterator迭代器
    public static void setWay2(){
        Set<String> set = new HashSet<>(3);
        
        for(Iterator iter = set.iterator();iter.hasNext();){
            String temp = (String)iter.next();
            System.out.println(temp);
        }
    }
    
    //根据key获取value
    public static void mapWay1(){
        Map<Integer, Man> maps = new HashMap<Integer, Man>();
        
        Set<Integer>  keySet =  maps.keySet();
        for(Integer id : keySet){
            System.out.println(maps.get(id).name);
        }
    }
    
    //使用entrySet
    public static void mapWay2(){
        Map<Integer, Man> maps = new HashMap<Integer, Man>();
    
        Set<Entry<Integer, Man>>  ss = maps.entrySet();
        for (Iterator iterator = ss.iterator(); iterator.hasNext();) {
            Entry e = (Entry) iterator.next(); 
            System.out.println(e.getKey()+"--"+e.getValue());
        }
    }
     
}

class Man{
    int id;
    String name;

    public Man(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    
}
