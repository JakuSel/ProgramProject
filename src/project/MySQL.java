package project;

import com.mysql.jdbc.Connection;
import java.awt.List;
import java.io.UncheckedIOException;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class MySQL {
    public ArrayList getAll(){   
        try{  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=(Connection) DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/prog_project","root","");  
                Statement stmt=(Statement) con.createStatement();  
                ResultSet rs=(ResultSet) stmt.executeQuery("select * from todo");  
                
                
                ArrayList<ToDoItem> resultList = new ArrayList<ToDoItem>();
                
                while(rs.next()){
                    String name = rs.getString("Name");
                    String desc = rs.getString("Description");
                    Date date = rs.getDate("Date");
                    Boolean status = rs.getBoolean("Status");
                    Integer id = rs.getInt("Id");
                    resultList.add(new ToDoItem(name, desc,date,status,id));
                }
                return resultList;                    
            }
        catch(Exception e){ System.out.println(e);}         
            return null;        
        }
    
    public void Insert(String name, String desc, Date date, Integer status){
        try{  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=(Connection) DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/prog_project","root","");  
                Statement stmt=(Statement) con.createStatement();  
                String query = "insert into todo (Name,Description,Date,Status) values ("
                        + "'"+name+"',"
                                + "'"+desc+"',"
                                        + "'"+date+"',"
                                                + "'"+status+"')";
                stmt.executeUpdate(query);  
                
                
            }
        catch(Exception e){ System.out.println(e);}         
        }
    public void Update(String name, String desc, Date date, Integer status,Integer id){
        try{  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=(Connection) DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/prog_project","root","");  
                Statement stmt=(Statement) con.createStatement();  
                String query = "update todo set "
                        + "Name='"+name+"',"
                        + "Description="+ "'"+desc+"',"
                        + "Date="+ "'"+date+"',"
                        +"Status="+ "'"+status+"'"
                        +"where Id=" +id;
                stmt.executeUpdate(query);  
                
                
            }
        catch(Exception e){ System.out.println(e);} 
    }
    public void Delete(Integer id){
        try{  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=(Connection) DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/prog_project","root","");  
                Statement stmt=(Statement) con.createStatement();  
                String query = "delete from todo where id = " +id;
                stmt.executeUpdate(query);
                
            }
        catch(Exception e){ System.out.println(e);} 
    }
 }  