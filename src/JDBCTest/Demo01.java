/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 测试跟数据库建立连接
 * @author WarSpite
 */
public class Demo01 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            long start = System.currentTimeMillis();
            //建立连接(连接对象内部其实包含了socket对象，是一个远程连接，比较耗时，这是connectiond对象管理的一个要点
            //真正开发中，为了提高效率，都会使用连接池来管理连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root","Zm111111");
            System.out.println(conn);
            long end = System.currentTimeMillis();
            System.out.println("建立连接，耗时:"+(end-start));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demo01.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Demo01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
