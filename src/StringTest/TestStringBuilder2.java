/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringTest;

/**
 * 测试StringBuilder，StringBuffer可变字符序列的常用方法
 * @author WarSpite
 */
public class TestStringBuilder2 {
    public static void main(String[]args){
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i<26;i++){
            char temp = (char)('a'+i);
            sb.append(temp);
        }
        
        System.out.println(sb);
        
        //倒序
        sb.reverse();
        System.out.println(sb);
        
        sb.setCharAt(3, '浩');
        System.out.println(sb);
        
        //链式调用，核心方法就是该方法调用了return this, 把自己给调用了
        sb.insert(0, '我').insert(6, '爱');
        System.out.println(sb);
        
        sb.delete(20, 23);
        System.out.println(sb);
        
        
        
        
    }
    
}
