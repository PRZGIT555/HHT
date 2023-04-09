package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest3 {

	public static void main(String[] args) {
		
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			//read inputs
			
			sc=new Scanner(System.in);
			String initChars=null;
			if(sc!=null) {
			System.out.println("Enter Initial Character of Emplyee Name::");
			 initChars=sc.next(); 
		
			}
			
			initChars="'"+initChars+"%'";
			
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sachin","Manager");
			
		  if(con!=null)
			  st=con.createStatement();
		  
		  String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE ENAME LIKE "+initChars;
		  System.out.println(query);
		  
		   if(st!=null) 
			   
			   rs=st.executeQuery(query);
		   
		   if(rs!=null) {
			   while(rs.next()!=false) {
				   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
			   }
		   }
			   
			   
		  
		}
		catch(SQLException se) {
			if(se.getErrorCode()>=900 && se.getErrorCode()<=999)
				System.out.println("Invalid col names");
			se.printStackTrace();
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
			
			
			try {
				if(st!=null)
					st.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
			
			
			
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
			
			
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			
			
			
		}
		
		
		
  
	}

}
