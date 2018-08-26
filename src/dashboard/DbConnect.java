/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DAWUD
 */
public class DbConnect {
     
        
       
    public static Connection getConnection() throws SQLException {
            Connection connection=null;
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory" ,"root","root");
            System.out.println("product DB Connect success"); 
            return connection;
    }
    
}
