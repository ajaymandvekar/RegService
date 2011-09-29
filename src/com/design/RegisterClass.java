package com.design;

import java.sql.*;

public class RegisterClass {
	public int registration(String Fname, String Lname, String Email){
				Connection conn = null;
				String url = "jdbc:mysql://localhost:3306/";
				String dbName = "cloudforce";
				String driver = "com.mysql.jdbc.Driver";
				String userName = "root"; 
				String password = "aj";
				
		  		try {
				  	Class.forName(driver).newInstance();
				  	conn = DriverManager.getConnection(url+dbName,userName,password);
			  	} 
		  		catch (Exception e) {
			  		return -1;
		  		}
		  
		  		Statement st = null;
		  		try {
		  				st = conn.createStatement();
		  		} catch (Exception e) {
		  				return -1;
		  		}
		  
		  		int present = 0;
		  		try {
					 ResultSet rs = st.executeQuery("select count(*) from organisation where orgEmail='"+ Email +"'");
				     rs.next();
				     present = Integer.parseInt(rs.getString(1));
				} catch (Exception e) {
					return -1;
				}
				
				int new_orgID = 0;
				
				if(present == 0)
				{
					try {
						 st.executeUpdate("INSERT INTO organisation(orgID,orgFname,orgLname,orgEmail) VALUES (NULL,'" + Fname + "','" + Lname + "','" + Email + "')", Statement.RETURN_GENERATED_KEYS);
						 ResultSet rs = st.executeQuery("SELECT LAST_INSERT_ID()");
					     rs.next();
					     new_orgID = Integer.parseInt(rs.getString(1));
					} catch (Exception e) {
						return -1;
					}
				}
				return new_orgID;
		}
}
