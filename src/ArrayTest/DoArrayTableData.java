/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayTest;

import java.util.Arrays;

/**
 * 测试数组存储表格数据
 * @author WarSpite
 */
public class DoArrayTableData {
    public static void main(String[]args){
        Object[] emp1 = {1001,"小王",18,"学生","1999.9.9"};
        Object[] emp2 = {1002,"小吴",30,"教授","1991.4.4"};
        Object[] emp3 = {1003,"小张",20,"老师","1987.2.2"};
        
        Object[][]tableData = new Object[3][];
        tableData[0] = emp1;
        tableData[1] = emp2;
        tableData[2] = emp3;
        
        for(Object[]temp:tableData){
            System.out.println(Arrays.toString(temp));
        }
        
    }
    
}
