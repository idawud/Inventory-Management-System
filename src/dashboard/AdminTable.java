/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

/**
 *
 * @author DAWUD
 */
public class AdminTable {
    String id,username,password,last_log;

    public AdminTable(String id, String username, String password, String last_log) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.last_log = last_log;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLast_log() {
        return last_log;
    }

    public void setLast_log(String last_log) {
        this.last_log = last_log;
    }
    
}
