/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCSORMTester.bean;

/**
 * 表中一个字段的信息
 * @author WarSpite
 */
public class ColumnInfo {
    /**
     * 字段名称
     */
    private String name;
    
    /**
     * 字段的数据类型
     */
    private String dataType;
    
    /**
     * 字段的键类型(0:普通键，1：主键，2:外键)
     */
    private int keyType;

    public ColumnInfo(String name, String dataType, int keyType) {
        this.name = name;
        this.dataType = dataType;
        this.keyType = keyType;
    }

    public ColumnInfo() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getKeyType() {
        return keyType;
    }

    public void setKeyType(int keyType) {
        this.keyType = keyType;
    }
    
    
}
