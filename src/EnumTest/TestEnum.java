/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnumTest;

/**
 *
 * @author WarSpite
 */
public class TestEnum {
    public static void main(String[]args){
        System.out.println(Season.SPRING);
        
        Season a = Season.AUTUMN;
        
        switch(a){
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case AUTUMN:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
        }
    }
}

enum Season{
    SPRING,SUMMER,AUTUMN,WINTER
}

enum Week{
    星期一,星期二,星期三,星期四,星期五,星期六,星期天
}