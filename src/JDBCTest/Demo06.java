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

/**事物的基本概念和用法
 * 成功传输就都传输，一个失败就不传输
 * @author WarSpite
 */
public class Demo06 {
    public static void main(String[] args) {
        
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root","Zm111111");
            
            conn.setAutoCommit(false);//JDBC中默认自动提交事物
            
            String sql1 = "insert into t_user (username,`password`) values(?,?)";//占位符
            ps1 = conn.prepareStatement(sql1);
            ps1.setObject(1, "王先生");
            ps1.setObject(2, "123456");
            ps1.execute();
            System.out.println("插入一个用户");
            
            String sql2 = "insert into t_user (username,`password`) values(?,?,?)";//占位符
            ps2 = conn.prepareStatement(sql2);
            ps2.setObject(1, "王先生2");
            ps2.setObject(2, "123456");
            ps2.execute();
            
            //上面false，下面就要有commit
            conn.commit();
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demo06.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.rollback();//回滚
            } catch (SQLException ex1) {
                Logger.getLogger(Demo06.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Demo06.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(ps1!=null){
                    ps1.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            try{
                if(ps2!=null){
                    ps2.close();
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
