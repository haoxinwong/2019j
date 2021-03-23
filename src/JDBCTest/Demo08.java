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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 测试时间处理（java.sql.Date, Time, TimeStamp)取出指定时间段的数据
 * @author WarSpite
 */
public class Demo08 {
    
    public static long str2Date(String dateStr){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return format.parse(dateStr).getTime();
        } catch (ParseException ex) {
            Logger.getLogger(Demo08.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    public static void main(String[] args) {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root","Zm111111");
            
            ps = conn.prepareStatement("select * from t_user where regTime>? and regTime<?");
            
            java.sql.Date start = new java.sql.Date(str2Date("2020-05-06 10:00:45"));
            java.sql.Date end = new java.sql.Date(str2Date("2020-05-09 23:57:45"));
            
            ps.setObject(1, start);
            ps.setObject(2, end);
            
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("id")+"--"+rs.getString("username")+"--"+rs.getDate("regTime"));
            }
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demo08.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Demo08.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
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
            
            try{
                if(rs!=null){
                    rs.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
