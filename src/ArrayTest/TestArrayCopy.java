/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayTest;

/**
 *
 * @author WarSpite
 */
public class TestArrayCopy {
    public static void main(String[]args){
        
        String []str = {"11","22","33","44","55"};
        addElement(str,1,"$$");
    }
    
    public static void testBasicCopy(){
        String[] s1 = {"aa","bb","cc","dd","ee"};
        String[] s2 = new String[10];
        //s1拷贝到s2，从s1的[2]开始，拷贝到s2的[6]，拷贝之后的三个数
        System.arraycopy(s1, 2, s2, 6, 3);
        for(int i = 0; i<s2.length;i++){
            System.out.println(i+"--"+s2[i]);
        }
    }
    
    //测试从数组中删除某个元素（本质上还是数组的拷贝）
    public static void testBasicCopy2(){
        String[] s1 = {"aa","bb","cc","dd","ee"};
        //dd,ee覆盖cc,dd  
        System.arraycopy(s1, 2, s1, 3-1, s1.length-3);
        //把s1的最后一个数字变成null
        s1[s1.length-1] = null;
        for(int i = 0; i<s1.length;i++){
            System.out.println(i+"--"+s1[i]);
        }
    }
    
    //删除数组中指定索引位置的元素，并将原数组返回
    public static String[] removeElement(String[]s,int index){

        //dd,ee覆盖cc,dd  
        System.arraycopy(s, index, s, index-1, s.length-index);
        //把s1的最后一个数字变成null
        s[s.length-1] = null;
        for(int i = 0; i<s.length;i++){
            System.out.println(i+"--"+s[i]);
        }
        return s;
    }
    
    //数组的扩容（本质上是先定义一个更大的数组，然后将原数组内容原封不动拷贝到新数组中）
    public static String[] extendRange(String[] s1){
        //String[]s1 = {"aa","bb","cc"};
        
        String[]s2 = new String[s1.length*2+2];
        
        System.arraycopy(s1, 0, s2, 0, s1.length);
        
        for(String temp:s2){
            System.out.println(temp);
        }
        return s2;
    }
    //在数组的指定位置插入一个元素
    public static String[] addElement(String[]s1,int index,String element){
        String[]s2 = new String[s1.length*2+2];
        
        System.arraycopy(s1, 0, s2, 0, index);
        
        s2[index]=element;
        
        System.arraycopy(s1, index, s2, index+1, s1.length-index);
        
        for(String temp:s2){
            System.out.println(temp);
        }
        return s2;
        
    }
   
    
}
