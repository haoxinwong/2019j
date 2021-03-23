/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCSORMTester.core;

/**
 * 负责java数据类型和数据库数据类型互相转换
 * @author WarSpite
 */
public interface TypeConvertor {
    
    /**
     * 将数据库类型转换成java数据类型
     * @param columnType 数据库字段的数据类型
     * @return java的数据类型
     */
    public String databaseType2JavaType(String columnType);
    
    /**
     * 负责将java数据类型转换成数据库数据类型
     * @param javaDataType java数据类型
     * @return  数据库数据类型
     */
    public String javaType2DatabaseType(String javaDataType);
}
