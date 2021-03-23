/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCORMTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 测试使用javabean对象来封装
 * @author WarSpite
 */
public class Demo03 {
    
    public static void test01(){
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs =null;
        //使用一个map分装一条记录
        Emp emp = null;
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where id=?");
            ps.setObject(1, 1);
            
            rs = ps.executeQuery();
            while(rs.next()){
                emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Demo03.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            JDBCUtil.colse(rs, ps, conn);
        }
        System.out.println(emp.getEmpname()+"-"+emp.getSalary()+"-"+emp.getAge());
    }
    
    public static void test02(){
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs =null;
        //list套list
        List<Emp>list = new ArrayList<>();
        Emp emp = null;
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where id>?");
            ps.setObject(1, 1);
            
            rs = ps.executeQuery();
            while(rs.next()){
                emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
                list.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Demo03.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            JDBCUtil.colse(rs, ps, conn);
        }
        //遍历map
        for(Emp tempEmp:list){
            System.out.println(tempEmp.getEmpname()+"-"+emp.getSalary()+"-"+emp.getAge());
        }
    }
    
    public static void main(String[] args) {
        test02();
    }
}
