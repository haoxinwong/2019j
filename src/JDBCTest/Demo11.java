/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCTest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
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
 * 测试使用JDBCUtil工具类来简化JDBC开发
 * @author WarSpite
 */
public class Demo11 {
    

    public static void main(String[] args) {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //加载驱动类
            conn = JDBCUtil.getMysqlConn();
            ps = conn.prepareStatement("insert into t_user(username) values(?)");
            ps.setString(1, "wan");
            ps.execute();
        
        } catch (Exception ex) {
            Logger.getLogger(Demo11.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            JDBCUtil.colse(rs, ps, conn);
        }
    }
}
