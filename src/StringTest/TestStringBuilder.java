/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringTest;

/**
 * 测试StringBuilder,StringBuffer
 * @author WarSpite
 */
public class TestStringBuilder {
    public static void main(String[]args){
        String str;
        //方便的修改数组内容
        //StringBuilde线程不安全，效率高（一般使用它）；StringBuffer线程安全，效率低
        StringBuilder sb = new StringBuilder("abcdefg");
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);
        
        sb.setCharAt(2, 'M');
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);
        
    
    
    
    }
    
    
    
    
    
    
    
    
}
