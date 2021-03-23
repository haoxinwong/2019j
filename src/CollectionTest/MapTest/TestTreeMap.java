/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.MapTest;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author WarSpite
 */
public class TestTreeMap {
    public static void main(String[]args){
        Map<Integer,String> treemap1 = new TreeMap<>();
        treemap1.put(20,"aa");
        treemap1.put(3, "bb");
        treemap1.put(6, "cc");
        
        //按照key递增的方式排序
        for(Integer key:treemap1.keySet()){
            System.out.println(key+"---"+treemap1.get(key));
        }
        
        Map<Emp,String> treemap2 = new TreeMap<>();
        treemap2.put(new Emp(100,"张三",50000),"111111");
        treemap2.put(new Emp(150,"张四",5000),"22222");
        treemap2.put(new Emp(170,"张五",6000),"2222");
        //薪水相同按id排序
        treemap2.put(new Emp(100,"张六",6000),"2222333");
        
        for(Emp key:treemap2.keySet()){
            System.out.println(key+"---"+treemap2.get(key));
        }
    }
    
}

//按照salary排序，就要implements Comparable，自己和自己比较
class Emp implements Comparable<Emp>{
    int id;
    String name;
    double salary;

    public Emp(int id, String name, double salary) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Emp o) {//写compareTo就这样写
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
