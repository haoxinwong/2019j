/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.SetTest;

import java.util.Set;
import java.util.TreeSet;

/**
 * 测试TreeSet的使用
 * 熟悉Comparable接口(可以参考TreeMap)
 * @author WarSpite
 */
public class TestTreeSet {
    public static void main(String[]args){
        Set <Integer>set1 = new TreeSet();
        
        set1.add(300);
        set1.add(200);
        set1.add(600);
        //按照元素递增的方法来排序
        for(Integer m:set1){
            System.out.println(m);
        }
        
        
        Set <Emp2> set2 = new TreeSet();
        set2.add(new Emp2(100,"李白",3000));
        set2.add(new Emp2(50,"张三",2000));
        set2.add(new Emp2(150,"赵云",8000));
        set2.add(new Emp2(30,"王一",30000));
        
        for(Emp2 m:set2){
            System.out.println(m);
        }
    }
    
}

//TreeMap拷贝过来的
class Emp2 implements Comparable<Emp2>{
    int id;
    String name;
    double salary;

    public Emp2(int id, String name, double salary) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Emp2 o) {//写compareTo就这样写
        //负数：小于，0：等于。正数：大于
        if(this.salary>o.salary){
            return 1;
        }else if(this.salary<o.salary){
            return -1;
        }else{
            //如果工资一样，就用id来排序
            if(this.id>o.id){
                return 1;
            }else if(this.id<o.id){
                return -1;
            }else{
                //id都一样那就没办法了
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return "id:" +id +".name:"+name+".salary:"+salary;
    }
    
}

