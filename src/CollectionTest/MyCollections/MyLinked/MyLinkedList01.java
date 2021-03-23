/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.MyCollections.MyLinked;

/**
 * 自定义一个链表
 * @author WarSpite
 */
public class MyLinkedList01 {
    //基本链表结构
    private Node first;
    private Node last;
    
    private int size;
    
    
    //[]
    //["a"]
    public void add(Object obj){
        Node node = new Node(obj);
        
        if(first == null){
           //node.previous = null;
           //node.next = null;
            //当第一个没有的时候，first和last都指向一个节点
            first = node;
            last = node;
        }else{
            //节点的上一个是最后一个
            node.previous = last;
            //节点的下一个是空
            node.next = null;
            //
            last.next = node;
            last = node;
            
        }
        
    }
    @Override
    //重写Object里面的toString
    public String toString() {
        //[a,b,c] first = a, last = c;
        //a,b,c
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while(temp!=null){
            sb.append(temp.element+",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length()-1, ']');
        return sb.toString();
    }
    
    public static void main(String[]args){
        MyLinkedList01 list = new MyLinkedList01();
        list.add("a");
        list.add("b");
        list.add("c");
        
        System.out.println(list);
    }
    
    
}
