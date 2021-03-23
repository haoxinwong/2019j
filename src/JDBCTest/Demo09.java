/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCTest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
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
 * 测试CLOB 文本对象
 * 包含：将字符串， 文件内容插入数据库中的CLOB字段，将CLOB字段值取出来的操作
 * @author WarSpite
 */
public class Demo09 {
    

    public static void main(String[] args) {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Reader r = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root","Zm111111");
            
//            ps = conn.prepareStatement("insert into t_user(username,myInfo) values (?,?)");
//            ps.setString(1, "王");
//            //将文本文件内容直接输入到数据库
////            ps.setClob(2, new FileReader(new File("C:\\Users\\WarSpite\\Desktop\\database_command.txt")));
//            //将程序的字符串输入到数据库的clob字段中
//            ps.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaabbb".getBytes()))));
            
            ps = conn.prepareStatement("select * from t_user where id = ?");
            ps.setObject(1, 21013);
            
            rs = ps.executeQuery();
            while(rs.next()){
                Clob c = rs.getClob("myInfo");
                r = c.getCharacterStream();
                int temp = 0;
                while((temp = r.read())!=-1){
                    System.out.print((char)temp);
                }
            }
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demo09.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Demo09.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(r!=null){
                    r.close();
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
