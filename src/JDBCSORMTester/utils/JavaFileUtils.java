/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCSORMTester.utils;

import JDBCSORMTester.bean.ColumnInfo;
import JDBCSORMTester.bean.JavaFieldGetSet;
import JDBCSORMTester.bean.TableInfo;
import JDBCSORMTester.core.MySqlTypeConvertor;
import JDBCSORMTester.core.TypeConvertor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 封装了生成Java文件(源代码）常用的操作
 * @author WarSpite
 */
public class JavaFileUtils {
    
    /**
     * 根据字段信息生成java属性信息，如var username-->private String username; 已经相应的set和get方法源码
     * 
     * @param column字段信息
     * @param convertor 类型转换器
     * @return java属性和set/get方法源码
     */
    public static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo column,TypeConvertor convertor){
        JavaFieldGetSet jfgs = new JavaFieldGetSet();
        
        String javaFieldType = convertor.databaseType2JavaType(column.getDataType());
        
        jfgs.setFieldInfo("\tprivate "+javaFieldType+" "+column.getName()+";\n");
        
        //生成get源码
        StringBuilder getSrc = new StringBuilder();
        getSrc.append("\tpublic "+javaFieldType+" get"+StringUtils.firstChar2UpperCase(column.getName())+"(){\n");
        getSrc.append("\t\treturn "+column.getName()+";\n");
        getSrc.append("\t}\n");
        jfgs.setGetInfo(getSrc.toString());
        
        //生成set源码
        StringBuilder setSrc = new StringBuilder();
        setSrc.append("\tpublic void set"+StringUtils.firstChar2UpperCase(column.getName())+"(");
        setSrc.append(javaFieldType+" "+column.getName()+"){\n");
        setSrc.append("\t\tthis. "+column.getName()+"="+column.getName()+";\n");
        setSrc.append("\t}\n");
        jfgs.setSetInfo(setSrc.toString());
        
        return jfgs;
    }
    
    
    /**
     * 根据表信息，生成java类的源代码
     * @param tableInfo 表信息
     * @param convertor 数据类型转化器
     * @return java类的源代码
     */
    public static String createJavaSrc(TableInfo tableInfo, TypeConvertor convertor){
        StringBuilder src = new StringBuilder();
        Map<String,ColumnInfo>columns = tableInfo.getColumns();
        List<JavaFieldGetSet>javaFields = new ArrayList<JavaFieldGetSet>();
        
        for(ColumnInfo c:columns.values()){
            javaFields.add(createFieldGetSetSRC(c,convertor));
        }
        
        //生成package语句
        //生成import语句
        
        //生成类声明语句
        
        //生成属性列表
        
        //生成get方法列表
        
        //生成set方法列表
        
        //生成类结束
        return null;
    }
    public static void main(String[] args) {
        ColumnInfo ci = new ColumnInfo("username","varchar",0);
        
        JavaFieldGetSet f = createFieldGetSetSRC(ci,new MySqlTypeConvertor());
        System.out.println(f);
    }
}
