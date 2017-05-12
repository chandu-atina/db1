package com.internship.assignment;
import java.sql.*;
import java.util.*;

class sqltest
{
private static Scanner sc;

public static void main(String args[])throws Exception
{
		int ch = 0;
		boolean flag=true;
		
		
		try
		{
			
		Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "admin");
			
			
			do
			{
			System.out.println("enter 1 for query 1/tenter two for query 2/tenter 3 for query 3/tenter 4 for query 4/n");
			
			 sc = new Scanner(System.in);
 
		switch (ch)
			{
			
			case 1 :
			try
			{
				Statement stmt1 = c.createStatement();
			ResultSet rs = stmt1.executeQuery("select * from emp order by salary desc limit 5");
			System.out.println("-----query 1----");
			while (rs.next())
			{
				System.out.println(rs.getInt(1) + "   " + rs.getString(2) + "   " + rs.getString(3) + "  "
						+ rs.getString(4) + "  " + rs.getInt(5) + "  " + rs.getInt(6));
				// System.out.println(rs.getInt(1));
			}
		   
			}
			 
			catch (Exception e)
			{
				System.out.println(e);
			}
			
			break ;
			
			
			case 2:
			try
			{
				Statement stmt = c.createStatement();
			
			ResultSet rs1 = stmt.executeQuery("select * from emp group by joining_date desc,designation desc limit 1");
			System.out.println("-----query 2----");
			while (rs1.next())
			{
				System.out.println(rs1.getInt(1) + "   " + rs1.getString(2) + "   " + rs1.getString(3) + "  "
						+ rs1.getString(4) + "  " + rs1.getInt(5) + "  " + rs1.getInt(6));
			}
			
			}
		 catch (Exception e)
			{
				System.out.println(e);
			}
			 break ;
			 
			 case 3:
			 try
			 {
				 Statement stmt = c.createStatement();
			 
			ResultSet rs2 = stmt.executeQuery(" select * from emp group by designation order by business_unit; ");
			System.out.println("-----query 3----");
			while (rs2.next())
			{
				//System.out.println(rs2.getInt(1));
				System.out.println(rs2.getInt(1) + "   " + rs2.getString(2) + "   " + rs2.getString(3) + "  "+ rs2.getString(4) + "  " + rs2.getInt(5) + "  " + rs2.getInt(6));
			}
			
			 }catch (Exception e)
			{
				System.out.println(e);
			}
			 break ;
			 
			case 4:
			try
			{
				Statement stmt = c.createStatement();
			
			ResultSet rs3 = stmt.executeQuery(" select * from emp group by designation order by joining_date desc limit 5 ");
			System.out.println("-----query 4----");
			while (rs3.next())
			{
			System.out.println(rs3.getInt(1) + "   " + rs3.getString(2) + "   " + rs3.getString(3) + "  "+ rs3.getString(4) + "  " + rs3.getInt(5) + "  " + rs3.getInt(6));
			}
			c.close();
		 }
			catch (Exception e)
		{
			System.out.println(e);
		}
			
		break;
			}
			System.out.println("do you want to continue?(y/n");
		
		String str=sc.nextLine();
	 if(str.equals("y"))
		 flag=true;
    if(str.equals("n"))
		flag=false;
			}
while(flag);
		}
		finally 
		{
			System.out.println("executed");
		}
}}