package com.codegnan.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class JdbcDemo_04 {

	public static void main(String[] args) {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/java";
		String username="root";
		String password="root";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id :");
		int id=sc.nextInt();
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, username, password);
			Statement stmt=con.createStatement();
			//String sql="delete from student where stu_id=102";
			String sql="delete from student where stu_id= "+id;
			int noRec=stmt.executeUpdate(sql);
			if(noRec==1) {
				System.out.println("deleted successfully");
			}
			else {
				System.out.println("we cant find the id to delete");
			}
			stmt.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
