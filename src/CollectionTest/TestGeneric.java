/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 泛型
 * @author WarSpite
 */
public class TestGeneric {
    public static void main(String[]args){
        MyCollection <String>mc = new MyCollection<String>();
        mc.set("hao",0);
        //mc.set(8888, 1);
        
        //Integer a = (Integer)mc.get(1);
        String b = mc.get(0);
        List list = new ArrayList();
        Map map = new HashMap();
    }
}

class MyCollection<E>{
    Object[]objs = new Object[5];
    
    public void set(E e,int index){
        objs[index] = e;
        
    }
    
    public E get(int index){
        return (E)objs[index];
    }
}
