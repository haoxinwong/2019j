/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.MyCollections.MyLinked;

/**
 * 自定义一个链表
 * 增加get方法
 * @author WarSpite
 */
public class MyLinkedList02 {
    //基本链表结构
    private Node first;
    private Node last;
    
    private int size;
    
    //[]
    //["a","b","c","d","e"]
    public Object get(int index){
        //找c的话
        //first.next.next,第一个的下一个的下一个
        //定义一个临时节点
        if(index<0||index>size-1){
            throw new RuntimeException("索引数字不合法："+index);
        }
        Node temp = null;
        
        //如果index的数字小于size的一半，从头开始往后找
        if(index<(size>>1)){//size>>1相当于除以2
            temp = first;
            for(int i = 0;i<index;i++){
                temp = temp.next;
            }
        }else{//如果index的数字大于size的一半，从后开始往前找
            temp = last;
            for(int i = size-1;i>index;i--){
                temp = temp.previous;
            }
        }
        
        return temp.element;
    }
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
        //每加一个节点，size++
        size++;
        
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
        MyLinkedList02 list = new MyLinkedList02();
        list.add("a");
        list.add("b");
        list.add("c");
        
        System.out.println(list);
        System.out.println(list.get(2));
    }
}
