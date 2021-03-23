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
 * 测试使用Map来封装一条记录
 * 使用List<Map>存储多条记录
 * @author WarSpite
 */
public class Demo02 {
    
    public static void test01(){
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs =null;
        //使用一个map分装一条记录
        Map<String,Object>row = new HashMap<String,Object>();
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where id=?");
            ps.setObject(1, 1);
            
            rs = ps.executeQuery();
            while(rs.next()){
                row.put("empname", rs.getObject(1));
                row.put("salary", rs.getObject(2));
                row.put("age", rs.getObject(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Demo02.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            JDBCUtil.colse(rs, ps, conn);
        }
        //遍历map
        for(String key:row.keySet()){
            System.out.println(key+"--"+row.get(key));
        }
    }
    
    public static void test02(){
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs =null;
        //list套list
        List<Map<String,Object>>list = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where id>?");
            ps.setObject(1, 1);
            
            rs = ps.executeQuery();
            while(rs.next()){
                Map<String,Object>row = new HashMap<String,Object>();
                row.put("empname", rs.getObject(1));
                row.put("salary", rs.getObject(2));
                row.put("age", rs.getObject(3));
                list.add(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Demo02.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            JDBCUtil.colse(rs, ps, conn);
        }
        //遍历map
        for(Map<String,Object>row:list){
            for(String key:row.keySet()){
                System.out.println(key+"--"+row.get(key));
            }
            System.out.println("");
        }
    }
    
    public static void test03(){
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs =null;
        //map套list
        Map<String,Map<String,Object>>map = new HashMap<>();
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where id>?");
            ps.setObject(1, 1);
            
            rs = ps.executeQuery();
            while(rs.next()){
                Map<String,Object>row = new HashMap<String,Object>();
                row.put("empname", rs.getObject(1));
                row.put("salary", rs.getObject(2));
                row.put("age", rs.getObject(3));
                map.put(rs.getString(1),row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Demo02.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            JDBCUtil.colse(rs, ps, conn);
        }
        //遍历map
        for(String empname:map.keySet()){
            for(String key:map.get(empname).keySet()){
                System.out.println(key+"--"+map.get(empname).get(key));
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        test03();
    }
}
