/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author cptja
 */
public class MySQL {
    public ArrayList getAll(){
        
    
        try{  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=(Connection) DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/prog_project","root","");  
                //here sonoo is database name, root is username and password  
                Statement stmt=(Statement) con.createStatement();  
                ResultSet rs=(ResultSet) stmt.executeQuery("select * from todo");  
                ArrayList<ToDoItem> resultList = new ArrayList<ToDoItem>();
                while(rs.next()){
                    String name = rs.getString("Name");
                    String desc = rs.getString("Description");
                    resultList.add(new ToDoItem(name, desc));
                }
                return resultList;                    
            }
        catch(Exception e){ System.out.println(e);}         
            return null;        
        }
}

