package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionsDemo {

	public static void main(String[] args) throws Exception
		{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Mrdy@1234");
        System.out.println("Driver is loaded");
        Statement stmt=con.createStatement();
        con.setAutoCommit(false);
        try
        {
        	int i1=stmt.executeUpdate("INSERT INTO candidate_skills VALUES(100,3)");
        	int i2=stmt.executeUpdate("UPDATE skills set name='Ruby' WHERE id=1");
        	int i3=stmt.executeUpdate("DELETE FROM candidates WHERE id=34");
        	
        	con.commit();
        	System.out.println("Transaction is success");
        }
        catch(Exception e)
        {
        	try
        	{
        		con.rollback();
        		System.out.println("Transaction is failed");
        	}
        	catch(Exception ex)
        	{
        		System.out.println(ex);
        	}
        }
        stmt.close();
        con.close();
        System.out.println("connection is closed");
	}

}
