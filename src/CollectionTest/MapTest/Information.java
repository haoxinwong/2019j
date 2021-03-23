/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.MapTest;

/**
 *
 * @author WarSpite
 */
public class Information {
    /**
     * 存储关系
     * Map就是用来存储key-value
     * Map类中存储的“键值对”通过键来标识，所以“key”不能重复
     */
    
    /**
     * HashMap底层实现采用了哈希表，这是一种非常重要的数据结构
     * (redis数据库的核心技术和HashMap一样
     * 哈希表的基本结构就是"数组+链表"
     * 1）数组：占用空间连续。寻址容易，查询速度快。但是增加和删除效率非常低
     * 2）链表：占用空间不连续。寻址困难，查询速度慢。但是增加和删除效率非常高
     * 
     * HashMap和HashTable基本上一样
     * 只不过HashTable的方法添加synchronized关键字确保线程同步检查
     * HashMap: 线程不安全，效率高。允许key或value为null
     * HashTable：线程安全，效率低。不允许key或Value为null
     */
    
    /**
     * TreeMap是红黑二叉树的典型实现
     * TreeMap和HashMap实现了同样的接口Map，用法对于调用者来说没有区别
     * HashMap效率高于TreeMap;在需要排序的Map时才选用TreeMap
     */
}
