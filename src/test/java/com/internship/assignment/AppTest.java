package com.internship.assignment;
import java.sql.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import junit.framework.*;
public class AppTest extends TestCase
{
	Connection c;
	Statement stmt;
	protected void setUp() throws Exception
	{
		try
	{
		Class.forName("com.mysql.jdbc.Driver");
	 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "admin");
	 stmt=c.createStatement();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
   
  public class JunitTest
  {
	   @Test 
    public void testApp()
    {
    	try
    	{
    	ResultSet rs = stmt.executeQuery("select * from emp order by salary desc limit 5");
    	Assert.assertNotNull(rs);
    	
    	ResultSet rs1 = stmt.executeQuery("select * from emp group by designation order by joining_date desc limit 5");
    	Assert.assertNotNull(rs1);
    	
    	ResultSet rs2 = stmt.executeQuery(" select * from emp group by designation order by business_unit; ");
    	Assert.assertNotNull(rs2);
    	
    	ResultSet rs3 = stmt.executeQuery(" select * from emp group by designation order by joining_date desc limit 5 ");
    	Assert.assertNotNull(rs3);
    	
     }
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	
  }
	   public class JUnitTest1
	   {
		   @Test
		   public void testApp()
		   {
			   System.out.println("executed");
		   }
	   }
	  
	   
  @RunWith(Suite.class)
  @Suite.SuiteClasses({JunitTest.class,JUnitTest1.class})
  
  public class JunitTestSuite{  }
   protected void tearDown()throws Exception
    	{
    c.close();
	stmt.close();
    }
  }}
	

