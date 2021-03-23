/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.MapTest;

/**
 * 测试hash算法
 * @author WarSpite
 */
public class TestHash {
    public static void main(String[]args){
        int h = 25860399;
        int length = 16;//length为2的整数次幂，则h&(length-1)相当于对length取模
        myHash(h,length);
        
    }
    
    /**
     * h 任意整数
     * length 长度必须为2的整数幂
     */
    public static int myHash(int h, int length){
        /*
        假设h为25,11001
        假设length为8
        &:运算法则是：如果两个整型数据a、b对应为都是1，则结果为才是1，否则为0。
        h&(length-1)
        length-1 = 7 = 111
        25&7 - 11001&111 = 11001
                             111
                           00001 = 1
        25%8                     = 1
        */
        System.out.println(h&(length-1));
        //length为2的整数幂情况下，和取余的值一样
        System.out.println(h%length);
        return h&(length-1);
    }
    
}
