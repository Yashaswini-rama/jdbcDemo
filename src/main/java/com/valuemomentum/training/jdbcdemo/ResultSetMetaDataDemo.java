package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetMetaDataDemo 
{
	
	public static void main(String[] args) {
	Connection con;
	
	try{  
   Class.forName("com.mysql.cj.jdbc.Driver");
   System.out.println("Connecting to database...");
   con=DriverManager.getConnection(  
    "jdbc:mysql://localhost:3306/classicmodels","root","Mrdy@1234");
	
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from employees");
	ResultSetMetaData rsmd=rs.getMetaData();
	//find the no of columns
	int count=rsmd.getColumnCount();
	for(int i=1;i <=count;i++)
	{
	System.out.println("column no :"+i);
	System.out.println("column name :"+rsmd.getColumnName(i));
	System.out.println("column type :"+rsmd.getColumnTypeName(i));
	System.out.println("column size :"+rsmd.getColumnDisplaySize(i));
	System.out.println("-----------");
	con.close();  
	}}
	catch(Exception e){ System.out.println(e);}  
	}  
	}  

