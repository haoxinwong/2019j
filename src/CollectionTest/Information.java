/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest;

/**
 *
 * @author WarSpite
 */
public class Information {
    /**
     * List是有序，可重复的容器
     * 有序：List中每个元素都有索引标记，可以根据元素的索引标记访问元素
     * 可重复：List允许加入重复的元素，
     *       更确切的讲，List通常允许满足e1.equals(e2)的元素重复加入容器
     * List接口常用的实现类有3个：ArrayList，LinkedList和Vector
     * 
     * ArrayList和Vector底层实现都是数组，Vector线程安全
     * ArrayList特点：查询效率高，增删效率低，线程不安全，一般使用它
     * LinekList底层实现是链表
     * 
     * Vector向量 - 底层实现时数组的List，相关的方法都加了同步检查
     *             比如indexOf方法就增加了synchronized同步标记
     * 
     * 1.需要线程安全时，用Vector
     * 2.不存在线程安全问题时，并查找较多用ArrayList（一般使用它）
     * 3.不存在线程安全问题时，增加或删除元素较多用LinkedList
     * 
     * Set：没有顺序，不可重复
     * List：有顺序，可以重复
     *
     * 
     * 
     */
    
}
