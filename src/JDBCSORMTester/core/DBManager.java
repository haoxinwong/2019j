/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCSORMTester.core;

import JDBCORMTest.JDBCUtil;
import JDBCSORMTester.bean.Configuration;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 根据配置信息，维持连接对象的管理， 增加连接池功能
 * @author WarSpite
 */
public class DBManager {
    private static Configuration conf;
    
    static{//静态代码块，只执行一次
        Properties pros = new Properties();
        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db_1.properties"));
        } catch (IOException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        conf = new Configuration();
        conf.setDriver(pros.getProperty("driver"));
        conf.setUrl(pros.getProperty("url"));
        conf.setUser(pros.getProperty("user"));
        conf.setPwd(pros.getProperty("pwd"));
        conf.setUsingDB(pros.getProperty("usingDB"));
        conf.setPoPackage(pros.getProperty("goPackage"));
        conf.setSrcPath(pros.getProperty("srcPath"));
    }
    
    public static Connection getConn() {
        try {
            Class.forName(conf.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return DriverManager.getConnection(conf.getUrl(), 
                    conf.getUser(), 
                    conf.getPwd()); //目前直接建立连接，后期增加连接池处理，提高效率
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void colse(ResultSet rs, Statement ps, Connection conn) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void colse(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
