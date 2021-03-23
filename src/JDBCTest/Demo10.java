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
 * 测试BLOB 二进制大对象的使用
 * @author WarSpite
 */
public class Demo10 {
    

    public static void main(String[] args) {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root","Zm111111");
            
//            ps = conn.prepareStatement("insert into t_user(username,headImg) values (?,?)");
//            ps.setString(1, "王");
//            ps.setBlob(2, new FileInputStream("C:\\HaoWang_College\\Bisc2\\bisci2.jpg"));
//            ps.execute();
            
            ps = conn.prepareStatement("select * from t_user where id = ?");
            ps.setObject(1, 21014);
            
            rs = ps.executeQuery();
            while(rs.next()){
                Blob b = rs.getBlob("headImg");
                is = b.getBinaryStream();
                os = new FileOutputStream("C:\\HaoWang_College\\tester.jpg");
                int temp = 0;
                while((temp = is.read())!=-1){
                    os.write(temp);
                }
            }
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demo10.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Demo10.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(is!=null){
                    is.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (os!=null) {
                    os.close();
                }
            } catch (Exception e) {
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
