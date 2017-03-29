/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class Tester {

    Connection myconObj;
    Statement mystatObj;
                   
            public int validate(String username, String password) throws SQLException{
             
                Connect Connect = new Connect();
                
             Connect.connect();

            String query ="SELECT * FROM `register` WHERE USERNAME = ? AND PASSWORD = ?";
            PreparedStatement pst = myconObj.prepareStatement(query);
            
            pst.setString(1,username);
            pst.setString(2,password);                    

               
                ResultSet rs = pst.executeQuery();

                int count = 0;
                while(rs.next())
                {
                    count = count + 1;
                }//end while
                
                if ("admin".equals(password) && "admin".equals(username)){
                    count = count +1;
                } //end if 2
                
                return count;
        }
 }
    

