/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.MyCollections.MyArray;

/**
 * 创立自己的arraylist
 * 增加泛型
 * 增加数组扩容
 * 增加set和get方法
 * 增加：数组边界的检查
 * 增加remove(E element)和remove(int index)
 * @author WarSpite
 */
public class MyArrayList05<E> {
    //封装private
    
    private Object[] elementData;
    private int size;
    
    private static final int DEFALT_CAPACITY = 10;//默认数组长度为10
    
    //无参构造器-如果用户没有传capacity，那就默认为10
    public MyArrayList05(){
        elementData =  new Object[DEFALT_CAPACITY];
    }
    
    //构造器-有传的话，那就用用户的
    public MyArrayList05(int capacity){
        if(capacity<0){
            throw new RuntimeException("容器的容量不能为负数");
        }else if(capacity == 0){
            elementData =  new Object[DEFALT_CAPACITY];
        }else{
            elementData = new Object[capacity];
        }
    }
    
    public void add(E element){
        //什么时候扩容？
        if(size == elementData.length){
            //怎么扩容？
            //创建一个新的数组
            Object [] newArray = new Object[elementData.length+(elementData.length>>1)];//10+10/2
            //把旧的数组copy到新的里面
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            //把旧的数组丢进垃圾回收站
            elementData = newArray;
        }
        elementData[size++]=element;
        
    }
    
    public E get(int index){
        //加E转型
        checkRange(index);
        return (E)elementData[index];
    }
    
    public void set(E element, int index){
        //索引合法判断[0,size) 10 0-9
        checkRange(index);
        elementData[index] = element;
    }
    
    public int size(){
        return this.size;
    }
    
    public boolean isEmpty(){
        for(int i = 0;i<size;i++){
            if (elementData[i] != null){
                return false;
            }
        }
        return true;
    }
    
    public void checkRange(int index){
        //索引合法判断[0,size) 10 0-9
        if(index<0||index>size+1){
            throw new RuntimeException("索引不合法:"+index);
        }
    }
    
    public void remove(E element){
        //element,将他和所有元素进行比较，获得第一个比较为true，返回
        for(int i =0;i<size;i++){
            if(element.equals(get(i))){//容器中所有的比较操作，都是用equals，而不是==
                //将该元素从此次移除
                remove(i);
            }
        }
    }
    
    public void remove(int index){
        //a,b,c,d,e
        //a,b,c,e
        checkRange(index);
        int numMoved = elementData.length-index-1;
        if(numMoved>0){
            System.arraycopy(elementData, index+1, elementData, index, numMoved); 
        }
        /*
        elementData[size-1] = null;
        size--;
        */
        //合并
        elementData[--size] = null;
    }

    @Override
    //重写Object里面的toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //实现-[a,b,c]
        //加[
        sb.append("[");
        //加a,b,c,
        for(int i = 0;i<size;i++){
            sb.append(elementData[i]+",");
        }
        //把最后一个char变成]
        sb.setCharAt(sb.length()-1, ']');
        /* 自己写的，不完美
        sb.append("[");
        for(int i = 0;i<size;i++){
            if(i==size-1){
                sb.append(elementData[i]);
            }else{
                sb.append(elementData[i]+",");
            }
        }
        sb.append("]");
        */
        return sb.toString();//[a,b,c]
    }
    
    
    public static void main(String[]args){
        MyArrayList05 <String>s1 = new MyArrayList05<String>(20);
        s1.add("ww");
        System.out.println(s1.isEmpty());
    }
}
