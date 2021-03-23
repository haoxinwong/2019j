/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCSORMTester.bean;

/**
 * 封装了java属性和get，set方法的源代码
 * @author WarSpite
 */
public class JavaFieldGetSet {
    /**
     * 属性的源码信息，如private int userId;
     */
    private String fieldInfo;
    /**
     * get方法的源码信息，如public int getUserID(){}
     */
    private String getInfo;
    /**
     * set方法的源码信息，如public void setUserId（int id){this.id = id;}
     */
    private String setInfo;

    @Override
    public String toString() {
        System.out.println(fieldInfo);
        System.out.println(getInfo);
        System.out.println(setInfo);
        return super.toString();
    }

    
    public String getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(String fieldInfo) {
        this.fieldInfo = fieldInfo;
    }

    public String getGetInfo() {
        return getInfo;
    }

    public void setGetInfo(String getInfo) {
        this.getInfo = getInfo;
    }

    public String getSetInfo() {
        return setInfo;
    }

    public void setSetInfo(String setInfo) {
        this.setInfo = setInfo;
    }

    public JavaFieldGetSet(String fieldInfo, String getInfo, String setInfo) {
        this.fieldInfo = fieldInfo;
        this.getInfo = getInfo;
        this.setInfo = setInfo;
    }

    public JavaFieldGetSet() {
        
    }
    
    
}
