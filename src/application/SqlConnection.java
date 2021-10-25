package application;

import java.sql.*;

public class SqlConnection{  
	public static Connection conn(){  
		try{  
		//Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection connection =null;
		Statement stmt = null;
		try
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx","root","");
			stmt = connection.createStatement();
			return connection;
		}catch(Exception e){ System.out.println(e);}
		}catch(Exception e) {
			
		}
		return null;
	} 


} 
