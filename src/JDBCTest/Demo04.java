/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 测试resultset, 返回结果
 * @author WarSpite
 */
public class Demo04 {
    public static void main(String[] args) {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root","Zm111111");
            
            String sql = "select id,username,`password` from t_user where id>?";//占位符
            ps = conn.prepareStatement(sql);
            ps.setObject(1, 2);//把id大于2的记录都取出来
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3));
            }
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demo04.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Demo04.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            //三个分开写
            try{
                if(rs!=null){
                    rs.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            
            try{
                if(ps!=null){
                    ps.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            
            try{
                if(conn!=null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
