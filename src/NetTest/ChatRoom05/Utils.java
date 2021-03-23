/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetTest.ChatRoom05;

import NetTest.ChatRoom04.*;
import NetTest.ChatRoom03.*;
import java.io.Closeable;

/**
 * 工具类
 * @author WarSpite
 */
public class Utils {
    /**
     * 释放资源
     */
    public static void close(Closeable...targets){
        for(Closeable target:targets){
            try{
                if(null!=target){
                    target.close();
                }
            }catch(Exception e){
                
            }
        }
    }
}
