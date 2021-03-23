/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.MyCollections.MyLinked;

/**
 * 自定义一个链表
 * 增加get方法
 * 增加remove
 * 插入一个节点
 * @author WarSpite
 */
public class MyLinkedList04 {
    //基本链表结构
    private Node first;
    private Node last;
    
    private int size;
    
    
    public void add(int index,Object obj){
        //设置一个新的节点
        Node newNode = new Node(obj);
        //旧节点
        Node temp = getNode(index);
        //如果有
        if(temp!=null){
            //设置上一个节点
            Node up = temp.previous;
            
            //原链表的下一个节点是新节点
            //新节点的上一个节点是原链表的节点
            up.next = newNode;
            newNode.previous = up;
            
            //新节点的下一个是旧节点
            //旧节点的上一个是新节点
            newNode.next = temp;
            temp.previous = newNode;
            
            //又大一个
            size++;
        }
    }
    public void remove(int index){
        Node temp = getNode(index);
        
        if(temp!=null){
            Node up = temp.previous;
            Node down = temp.next;
            if(up!=null){
                up.next = down;
            }
            
            if(down!=null){
                down.previous = up;
            }
            //被删除的元素是第一个元素时
            if(index == 0){
                first = down;
            }
            //被删除的元素时是最后一个时
            if(index == size-1){
                last = up;
            }
            size--;
        }
        
    }
    //[]
    //["a","b","c","d","e"]
    public Object get(int index){
        //找c的话
        //first.next.next,第一个的下一个的下一个
        //定义一个临时节点
        if(index<0||index>size-1){
            throw new RuntimeException("索引数字不合法："+index);
        }
        
        Node temp = getNode(index);
        return temp!=null?temp.element:null;
    }
    
    //封装的get方法，方便以后使用
    public Node getNode(int index){
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
        return temp;
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
        MyLinkedList04 list = new MyLinkedList04();
        list.add("a");
        list.add("b");
        list.add("c");
        
        System.out.println(list);
        System.out.println(list.get(2));
        list.remove(0);
        System.out.println(list);
    }
    
}

