/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.MyCollections.MyMaps;

/**
 * 自定义一个HashMap
 * 实现了put方法增加键值对，并解决了键重复的时候覆盖相应的节点
 * @author WarSpite
 */
public class MyHashMap01 {
    
    Node2[] table;//位桶数组， bucket array
    int size;      //存放的键值对的个数
    
    public MyHashMap01(){
        table = new Node2[16]; //长度一般定义成2的整数幂
    }
    
    public void put(Object key, Object value){
        //定义新的节点对象
        Node2 newNode = new Node2();
        newNode.hash = myHash(key.hashCode(),table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;
        
        Node2 temp = table[newNode.hash];
        
        Node2 iterLast = null;//正在遍历的最后一个元素
        
        boolean keyRepeat = false;
        if(temp==null){
            //此处数组元素为空，则直接将新节点放进去
            table[newNode.hash] = newNode;
        }else{
            //此处数组不为空，则遍历对应链表。。
            while(temp!=null){
                
                //判断key如果重复，则覆盖
                if(temp.key.equals(key)){
                    //如果执行覆盖了，就没必要执行iterLast.next = newNode;
                    //所以设置keyRepeat
                    keyRepeat = true;
                    temp.value = value;//只是覆盖value，其他的值（hash，key，next）保持不变
                    //覆盖之后，就可以结束整个循环
                    break;
                }else{
                    //key不重复,则遍历下一个
                    iterLast = temp;
                    temp = temp.next;
                    
                }
            }
            
            if(!keyRepeat){//没有发生key重复的情况，则添加到链表最后
                iterLast.next = newNode;
            }
            
        }
    }
    
    public static int myHash(int v, int length){
        //System.out.println(v&(length-1));
        return v&(length-1);//直接位运算，效率高
        //return v%(length);//取模运算，效率低
    }
    
    public static void main(String[]args){
        MyHashMap01 m = new MyHashMap01();
        m.put(10,"aa");
        m.put(20,"bb");
        m.put(30,"cc");
        m.put(20, "ssss");
        m.put(53, "11");
        m.put(69, "22");
        m.put(85, "33");
        
        System.out.println(m);
        
        for(int i = 10;i<100;i++){
            System.out.println(i+"---"+myHash(i,16));//53,69,85 - 
        }
    }
}
