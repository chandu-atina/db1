package com.internship.assignment;
import java.sql.*;
class sqltest
{
	public static void main(String args[])
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "admin");
			if(Integer.parseInt(args[0]) ==1 )
			{
				System.out.println("accepts 1");
			}
				else if (Integer.parseInt(args[0]) == 2)
			{
		System.out.println("accepts 2");
			} 
			else
			{
				System.out.println("does not accept");
			}
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp order by salary desc limit 5");
			System.out.println("-----query 1----");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "   " + rs.getString(2) + "   " + rs.getString(3) + "  "
						+ rs.getString(4) + "  " + rs.getInt(5) + "  " + rs.getInt(6));
				// System.out.println(rs.getInt(1));
			}
			ResultSet rs1 = stmt.executeQuery("select * from emp group by joining_date desc,designation desc limit 1");
			System.out.println("-----query 2----");
			while (rs1.next()) {
				System.out.println(rs1.getInt(1) + "   " + rs1.getString(2) + "   " + rs1.getString(3) + "  "
						+ rs1.getString(4) + "  " + rs1.getInt(5) + "  " + rs1.getInt(6));
              }
			ResultSet rs2 = stmt.executeQuery(" select * from emp group by designation order by business_unit; ");
			System.out.println("-----query 3----");
			while (rs2.next())
			{
				//System.out.println(rs2.getInt(1));
				System.out.println(rs2.getInt(1) + "   " + rs2.getString(2) + "   " + rs2.getString(3) + "  "+ rs2.getString(4) + "  " + rs2.getInt(5) + "  " + rs2.getInt(6));
			}
			ResultSet rs3 = stmt.executeQuery(" select * from emp group by designation order by joining_date desc limit 5 ");
			System.out.println("-----query 4----");
			while (rs3.next())
			{
			System.out.println(rs3.getInt(1) + "   " + rs3.getString(2) + "   " + rs3.getString(3) + "  "+ rs3.getString(4) + "  " + rs3.getInt(5) + "  " + rs3.getInt(6));
			}
			con.close();
		 }catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
