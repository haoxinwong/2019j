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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 测试使用Object[]来封装一条记录
 * @author WarSpite
 */
public class Demo01 {
    public static void main(String[] args) {
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs =null;
        List<Object[]>list = new ArrayList<Object[]>();
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where id>?");
            ps.setObject(1, 1);
            
            rs = ps.executeQuery();
            while(rs.next()){
                Object[]obj = new Object[3];
//                System.out.println(rs.getString(1));
                obj[0] = rs.getString(1);
                obj[1] = rs.getObject(2);
                obj[2] = rs.getObject(3);
                list.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Demo01.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            JDBCUtil.colse(rs, ps, conn);
        }
        list.forEach((item) -> {
            System.out.println(""+item[0]+item[1]);
        });
    }
}
