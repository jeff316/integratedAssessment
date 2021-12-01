/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.*;


/**
 *
 * @author Jefferson
 */
public class ConnectionModule {
    //connects to database
    public static Connection conector(){
        Connection con = null;
    //call the driver
        String driver ="com.mysql.cj.jdbc.Driver";
    //store information about the database
        String url = "jdbc:mysql://localhost:3306/dbequationsolver";
        String user = "root";
        String password = "root";
     //establishing connection with the database
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url ,user, password);
            return con;
            
        } catch (Exception e) {
            //System.out.println(e);
            return null;
            
        }
    }     
}
