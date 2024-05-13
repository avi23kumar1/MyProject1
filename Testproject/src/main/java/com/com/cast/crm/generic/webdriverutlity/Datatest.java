package com.com.cast.crm.generic.webdriverutlity;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class Datatest {
	Connection conn;
	public void getDataBaseConnection(String url,String userName,String password) throws Throwable {
		try {
		Driver driver=new Driver();
			DriverManager.registerDriver(driver);
	 Connection	conn=DriverManager.getConnection(url, userName, password);
	}
   catch(Exception e)
		{
	   
		}
}
	public void getDBConnection() throws Throwable{
	
		try {
		Driver driver=new Driver();
			DriverManager.registerDriver(driver);
	 Connection	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root","root");
	}
   catch(Exception e)
		{
	   
		}
}
	public void closeConnection() throws Throwable {
		conn.close();
	}
	public ResultSet executeNonSelectQuery(String query) throws Throwable {
		ResultSet result=null;
		try {
		Statement stat= conn.createStatement();
	    result=stat.executeQuery(query);
		}
		catch(Exception e) {
		}
		return result;
	}
	public int executeSelectQuery(String query) {
		int result=0;
		try {
				Statement stat=conn.createStatement();
			    result=stat.executeUpdate(query);
				}
				catch(Exception e) {
				}
				return result;
			
		}


}
