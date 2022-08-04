package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BankDetails 
{
	private int accno;
	private String name;
	private String acc_type;
	private int balance;
	private int amnt;
	static String sql = "";
	Scanner sc = new Scanner(System.in);
		
	public void openAccount() 
	{
		System.out.println("Enter Name");
		name  = sc.next();
		System.out.println("Enter Account Type");
		acc_type  = sc.next();
		System.out.println("Enter Amount to create account");
		balance = sc.nextInt();
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String userName = "scott";
			String password = "tiger";
			
			Connection con = DriverManager.getConnection(url, userName, password);
			
			Statement stmt = con.createStatement();
			
			sql = "insert into customers(cname,ac_type,balance) values ('"+name+"','"+acc_type+"','"+balance+"')";
			stmt.executeUpdate(sql);
			System.out.println("Account Created");
			ResultSet rs = stmt.executeQuery("select ac_no from customers where cname='"+name+"' ");
			while(rs.next())
			{
				System.out.println("Account Number : "+rs.getLong(1));
			}
			rs.close();
			stmt.close();
		}
		catch (ClassNotFoundException e)
		{
			
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	
	public void checkBalance()
	{
		System.out.println("Enter Name");
		name  = sc.next();
		System.out.println("Enter Account Number");
		accno  = sc.nextInt();
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String userName = "scott";
			String password = "tiger";
			
			Connection con = DriverManager.getConnection(url, userName, password);
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from customers where ac_no = '"+accno+"' ");
			//System.out.println("Hello");
			while(rs.next())
			{
				//System.out.println("Hello");
				System.out.println("Balance : "+rs.getLong(4));
				//System.out.println("ACC no: "+rs.getLong(1)+ " Name: "+rs.getString(2)+"Type: "+rs.getString(3)+"Bal: "+rs.getLong(4));
			}
			//System.out.println("Hello");
			rs.close();
			stmt.close();
		}
		catch (ClassNotFoundException e)
		{
			
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	
	public void deposit()
	{
		System.out.println("Enter Account Number ");
		accno = sc.nextInt();
		System.out.println("Enter the Amount you want to deposit ");
	    amnt = sc.nextInt();
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String userName = "scott";
			String password = "tiger";
			
			Connection con = DriverManager.getConnection(url, userName, password);
			
			Statement stmt = con.createStatement();
			
			//String sql = "update customers set balance = balance + '" +amnt+"' where" + "ac_no = '" + accno+"' ";
			 sql = "update customers set balance = balance + '"+amnt+"' where ac_no = '"+accno+"' ";
			stmt.executeUpdate(sql);
			System.out.println("Amount Deposited Successfully");
			ResultSet rs = stmt.executeQuery("select * from customers where ac_no='"+accno+"' ");
			while(rs.next())
			{
				System.out.println("Balance : "+rs.getLong(4));
			}
			rs.close();
			stmt.close();
			
		}
		catch (ClassNotFoundException e)
		{
			
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	
	public void withdraw()
	{
		System.out.println("Enter Account Number ");
		accno = sc.nextInt();
		System.out.println("Enter the Amount you want to withdraw ");
	    amnt = sc.nextInt();
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String userName = "scott";
			String password = "tiger";
			
			Connection con = DriverManager.getConnection(url, userName, password);
			
			Statement stmt = con.createStatement();
			
			//String sql = "Update customers set balance = balance + '"+amnt+"' where" + "ac_no = '"+accno+"' ";
			 sql = "update customers set balance = balance - '"+ amnt+"' where ac_no= '"+accno+"' ";
			//stmt.executeUpdate("Update customers set balance = balance -'"+amnt+"' where" + "ac_no = '"+accno+"' ");
			stmt.executeUpdate(sql);
			System.out.println("Amount Withdrawn Successfully");
			ResultSet rs = stmt.executeQuery("select * from customers where ac_no= '"+accno+"' ");
			while(rs.next())
			{
				System.out.println("Balance : "+rs.getLong(4));
			}
			rs.close();
			stmt.close();
			
		}
		catch (ClassNotFoundException e)
		{
			
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	

}
