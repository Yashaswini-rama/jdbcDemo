package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
//	import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteDemo {

	public static void main(String[] args) 
	{
		Connection con;
		Statement stmt;
		//ResultSet rs;
		int cnt=0;
		
		try
		{
			//Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Open a connection
			System.out.println("Connecting to database");
			con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/mysqljdbc","root","Mrdy@1234");
			
			String sql="Delete from candidates where rtrim(last_name) like 'Y%';";
			System.out.println(" ");
			stmt=con.createStatement();
			cnt=stmt.executeUpdate(sql);
			
			if(cnt>0)
			{
				System.out.println("Records for Young is deleted");
			}
			else
			{
				System.out.println("Record not found");
			}
			con.close();
	}
		catch(Exception ce)
		{
			System.out.println(ce);
		}

}
}
