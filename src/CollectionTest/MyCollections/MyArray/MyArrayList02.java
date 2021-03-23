/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.MyCollections.MyArray;

/**
 * 创立自己的arraylist
 * 增加泛型
 * @author WarSpite
 */
public class MyArrayList02<E> {
    //封装private
    
    private Object[] elementData;
    private int size;
    
    private static final int DEFALT_CAPACITY = 10;//默认数组长度为10
    
    //无参构造器-如果用户没有传capacity，那就默认为10
    public MyArrayList02(){
        elementData =  new Object[DEFALT_CAPACITY];
    }
    
    //构造器-有传的话，那就用用户的
    public MyArrayList02(int capacity){
        elementData = new Object[capacity];
    }
    
    public void add(E element){
        elementData[size++]=element;
        
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
        MyArrayList02 <String>s1 = new MyArrayList02<String>(20);
        s1.add("aa");
        s1.add("bb");
        System.out.println(s1.toString());
    }
}
