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
import java.sql.Timestamp;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 测试时间处理（java.sql.Date, Time, TimeStamp)
 * Date - 年月日
 * TimeStamp - 年月日时分秒
 * @author WarSpite
 */
public class Demo07 {
    public static void main(String[] args) {
        
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root","Zm111111");
            
            conn.setAutoCommit(true);//JDBC中默认自动提交事物
            
            for (int i = 0; i < 1000; i++) {
                String sql1 = "insert into t_user (username,`password`,regTime,lastLoginTime) values(?,?,?,?)";//占位符
                ps1 = conn.prepareStatement(sql1);
                ps1.setObject(1, "war"+i);
                ps1.setObject(2, "123456");
                
                int rand = 1000000+new Random().nextInt(100000);
                java.sql.Date date = new java.sql.Date(System.currentTimeMillis()-rand);
                ps1.setDate(3, date);
                Timestamp stamp = new Timestamp(System.currentTimeMillis()-rand);//如果需要插入指定日期，可以使用Calendar
                ps1.setTimestamp(4, stamp);
                ps1.execute();
            }
            

        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demo07.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Demo07.class.getName()).log(Level.SEVERE, null, ex);
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
