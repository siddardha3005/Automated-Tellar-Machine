/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manag;

import java.sql.*;

public class Conn {
Connection c;
   Statement s;
  
    public Conn()
    {
        
        try
        {
            
                         Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql:///bunny","root","root" );
			
                       s=c.createStatement();
                       
	}catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
