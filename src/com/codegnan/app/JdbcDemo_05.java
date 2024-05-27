package com.codegnan.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo_05 {
	public static void main(String [] args) {
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/java";
	String username="root";
	String password="root";
	Scanner sc=new Scanner(System.in);
	System.out.println("enter id :");
	int id=sc.nextInt();
	try {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt=con.createStatement();
		String sql="select * from student where stu_id ="+id;
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next()) {
			
			String name=rs.getString("stu_name");
			String email=rs.getString("email");
			String branch=rs.getString("branch");
			System.out.println(id+"-"+name+"-"+email+"-"+branch);
		}
		else {
			System.out.println("student not found with id is "+id);
		}
		stmt.close();
		con.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

}
