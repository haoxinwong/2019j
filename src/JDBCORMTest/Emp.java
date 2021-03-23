/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCORMTest;

import java.sql.Date;

/**
 *表结构和类对应
 * @author WarSpite
 */
public class Emp {
    private Integer id;
    private String empname;
    private Double salary;
    private Date birthday;
    private Integer age;
    private Integer deptId;

    public Emp() {
        
    }

    public Emp(String empname, Double salary, Integer age) {
        this.empname = empname;
        this.salary = salary;
        this.age = age;
    }

    
    public Emp(Integer id, String empname, Double salary, Date birthday, Integer age, Integer deptId) {
        this.id = id;
        this.empname = empname;
        this.salary = salary;
        this.birthday = birthday;
        this.age = age;
        this.deptId = deptId;
    }

    
    public Emp(String empname, Double salary, Date birthday, Integer age, Integer deptId) {
        this.empname = empname;
        this.salary = salary;
        this.birthday = birthday;
        this.age = age;
        this.deptId = deptId;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    
    
}
