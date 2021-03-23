/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCSORMTester.core;

import JDBCSORMTester.bean.ColumnInfo;
import JDBCSORMTester.bean.TableInfo;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 负责获取管理数据库所有表结构和类结构的关系，并可以根据表结构生成类结构
 * @author WarSpite
 */
public class TableContext {
    
    /**
     * 表名为key，表信息对象为value
     */
    private static Map<String,TableInfo> tables = new HashMap<>();
    
    /**
     * 将po的class对象和表信息对象关联起来，便于重用！
     */
    public static Map<Class, TableInfo>poClassTableMap = new HashMap<Class,TableInfo>();
    
    private TableContext(){
        
    }
    
    static {
        try {
            //初始化获得表的信息
            Connection con = DBManager.getConn();
            DatabaseMetaData dbmd = con.getMetaData();
            
            ResultSet tableRet = dbmd.getTables(null,"%","%",new String[]{"TABLE"});
            
            while(tableRet.next()){
                String tableName = (String)tableRet.getObject("TABLE_NAME");
                TableInfo ti = new TableInfo(tableName, new ArrayList<ColumnInfo>(),
                        new HashMap<String, ColumnInfo>());
                tables.put(tableName, ti);
                
                ResultSet set = dbmd.getColumns(null, "%", tableName, "%");
                while(set.next()){
                    ColumnInfo ci = new ColumnInfo(set.getString("COLUMN_NAME"),
                    set.getString("TYPE_NAME"),0);
                    ti.getColumns().put(set.getString("COLUMN_NAME"), ci);
                }
                
                ResultSet set2 = dbmd.getPrimaryKeys(null, "%", tableName);
                while(set2.next()){
                    ColumnInfo ci2 = (ColumnInfo)ti.getColumns().get(set2.getObject("COLUMN_NAME"));
                    ci2.setKeyType(1);
                    ti.getPriKeys().add(ci2);
                }
                
                if(ti.getPriKeys().size()>0){
                    ti.setOnlyPriKey(ti.getPriKeys().get(0));
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        Map<String,TableInfo>tables = TableContext.tables;
        System.out.println(tables);
    }
}
