/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.ListTest;
import java.util.*;
/**
 * 测试Collection接口中的方法
 * @author WarSpite
 */
public class TestList {
    public static void main(String[]args){
        test03();
        
        
    }
    public static void test01(){
        Collection <String>c = new ArrayList();
        
        System.out.println(c.size());
        System.out.println(c.isEmpty());
        c.add("hao1");
        c.add("hao2");
        System.out.println(c.size());
        System.out.println(c.isEmpty());
        
        System.out.println(c.contains("hao2"));
        
        Object[] objs = c.toArray();
        System.out.println(objs);
                
        c.remove("hao2");
        System.out.println(c.toString());
       
        c.clear();
    }
    
    public static void test02(){
        List <String>list01 = new ArrayList<>();
        list01.add("aa");
        list01.add("bb");
        list01.add("cc");
        
        List<String>list02 = new ArrayList<>();
        list02.add("aa");
        list02.add("dd");
        list02.add("ee");
        
        System.out.println("list01: "+list01);
        
        //将c容器中的所有元素加到本容器中
        //list01.addAll(list02); //[aa, bb, cc, aa, dd, ee]
        //移除本容器和c容器中都有的元素
        //list01.removeAll(list02);//[bb, cc]
        //取本容器和c容器中都包含的元素，移除非交集的元素
        list01.retainAll(list02);//[aa]
        System.out.println("list01: "+list01);
        //本容器是否包含c容器中的所有元素
        System.out.println(list01.containsAll(list02));
    }
    
    public static void test03(){
        List <String>list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        
        System.out.println(list);
        //在指定位置加元素
        list.add(2,"hao");
        System.out.println(list);
        //删除指定位置元素
        list.remove(2);
        System.out.println(list);
        //设定指定位置元素
        list.set(2,"hal");
        System.out.println(list);
        //获得指定位置元素
        System.out.println(list.get(2));
        
        list.add("C");
        list.add("B");
        list.add("A");
        System.out.println(list);
        //第一个出现的元素的位置
        System.out.println(list.indexOf("B"));
        //从后开始第一个出现元素的位置
        System.out.println(list.lastIndexOf("B"));
        
    }
}
