/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.MapTest;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author WarSpite
 */
public class TestHashMap2 {
    public static void main(String[]args){
        
        Employee e1 = new Employee(1001,"hao1",50000);
        Employee e2 = new Employee(1002,"hao2",400);
        Employee e3 = new Employee(1003,"hao3",3000);
        
        Map<Integer,Employee> map = new HashMap<>();
        System.out.println(e1.hashCode());
        map.put(1001, e1);
        map.put(1002, e2);
        map.put(1003, e3);
        
        Employee emp = map.get(1001);
        System.out.println(emp.getEname());
        
        System.out.println(map);
    }
}

//雇员信息
class Employee{
    private int id;
    private String ename;
    private double salary;

    public Employee(int id, String ename, double salary) {
        super();
        this.id = id;
        this.ename = ename;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", ename=" + ename + ", salary=" + salary + '}';
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
    
    
}
