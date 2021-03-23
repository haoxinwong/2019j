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
 * 测试批处理的方法 Batch
 * @author WarSpite
 */
public class Demo05 {
    public static void main(String[] args) {
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root","Zm111111");
            
            conn.setAutoCommit(false);//设为手动提交
            
            stmt = conn.createStatement();
            long start = System.currentTimeMillis();
            for(int i = 0;i<20000;i++){
                stmt.addBatch("insert into t_user (username,`password`,regTime) values('王"+i+"',6666,now())");
            }
            stmt.executeBatch();
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println("两万数据，耗时:"+(end-start));
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demo05.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Demo05.class.getName()).log(Level.SEVERE, null, ex);
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
                if(stmt!=null){
                    stmt.close();
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
