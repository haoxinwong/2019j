/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCORMTest;

/**
 *
 * @author WarSpite
 */
public class Dept {
    private Integer id;
    private String dname;
    private String address;

    public Dept() {
        
    }

    
    public Dept(Integer id, String dname, String address) {
        this.id = id;
        this.dname = dname;
        this.address = address;
    }

    
    public Dept(String dname, String address) {
        this.dname = dname;
        this.address = address;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
