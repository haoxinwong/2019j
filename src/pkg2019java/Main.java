/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2019java;

import java.util.LinkedList;

/**
 *
 * @author WarSpite
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<Integer>list = new LinkedList();
        for(int i = 0; i<10;i++){
            list.add(i);
        }
        list.remove(5);
        
        System.out.println(list.toString());
    }
    
}
