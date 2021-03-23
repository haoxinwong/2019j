/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTest.TestObject;

import IOTest.TestData.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 对象流+缓冲
 * 1.写出后读取
 * 2.读取的顺序保持一致
 * 3.不是所有的对象都可以序列化Serializable
 * ObjectOutputStream
 * ObjectInputStream
 * 
 * 面试：请将某某某转成字节数组或占用多少字节
 * 
 * @author WarSpite
 */
public class ObjectTest01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //写出-->序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
        //操作数据类型+数据
        oos.writeUTF("浩");
        oos.writeInt(18);
        oos.writeBoolean(false);
        oos.writeChar('a');
        //还支持对象
        oos.writeObject("解");//String 实现serializable可以序列化
        oos.writeObject(new Date());//date也实现serializable
        Employee emp = new Employee("马云",400);
        oos.writeObject(emp);
        oos.flush();
        
        byte []datas = baos.toByteArray();
        System.out.println(datas.length);
        //读取-->反序列化
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //顺序与写出一致
        String msg = ois.readUTF();
        int age = ois.readInt();
        boolean flag = ois.readBoolean();
        char ch = ois.readChar();
        System.out.println(flag);
        //对象的数据还原
        Object str = ois.readObject();
        Object date = ois.readObject();
        Object employee = ois.readObject();
        
        if(str instanceof String){
            String strObj = (String)str;
            System.out.println(strObj);
        }
        if(date instanceof Date){
            Date dateObj = (Date)date;
            System.out.println(dateObj);
        }
        if(employee instanceof Employee){
            Employee employeeObj = (Employee)employee;
            System.out.println(employeeObj.getName()+"--->"+employeeObj.getSalary());
        }
    }
}

//javabean 封装数据
class Employee implements java.io.Serializable{
    private transient String name;//指该数据不需要序列化
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        super();
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
}