/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 测试PreparedStatement的基本用法
 * @author WarSpite
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root","Zm111111");
            
            String sql = "insert into t_user (username,`password`,regTime) values(?,?,?)";//?占位符
            PreparedStatement ps = conn.prepareStatement(sql);
            //一种方式
//            ps.setString(1, "WarSp");//索引是从1开始算，而不是0
//            ps.setString(2, "12213");
//            ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            
            //第二种就都是object  全都是object
            ps.setObject(1, "WarSp2");
            ps.setObject(2, "1212121323");
            ps.setObject(3, new java.sql.Date(System.currentTimeMillis()));
            System.out.println("插入一行记录");
            ps.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demo03.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Demo03.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
