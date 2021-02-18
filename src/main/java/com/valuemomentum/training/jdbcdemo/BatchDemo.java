package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.Statement;

public class BatchDemo 
{

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Mrdy@1234");
        Statement stmt=con.createStatement();
        
        stmt.addBatch("INSERT INTO candidate_skills VALUES(100,5)");
        stmt.addBatch("UPDATE skills set name='Ajax' WHERE id=3");
        stmt.addBatch("DELETE from candidates WHERE id=80");
        
        //disable auto commit
        con.setAutoCommit(false);
        try
        {
        	stmt.executeBatch();
        	con.commit();
        	System.out.println("Batch is successfully executed");
        }
        catch(Exception e)
        {
        	try
        	{
        		con.rollback();
        		System.out.println("Batch is failed");
        		System.out.println("Exception is"+e);
        	}
        	catch(Exception e1)
        	{
        		System.out.println("Exception is"+e1);
        	}
        }
        stmt.close();
        con.close();
	}

}
