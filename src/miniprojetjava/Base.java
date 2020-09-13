/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojetjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author asus
 */
public class Base {
    
    
    Connection cnx=null;
    ResultSet Rs=null;
    PreparedStatement ps=null;

    public static Connection ConnectDB()
    {
        try
        {
             Class.forName("com.mysql.jdbc.Driver");
             String url = "jdbc:mysql://localhost:3306/java";
             String user = "root";
             String passwd = "";
             Connection cnx=DriverManager.getConnection(url, user, passwd);
             
             return cnx;
        }
        catch(Exception e)
        { 
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
        
    }
}
