package com.codegnan.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo_07 {

	public static void main(String[] args) {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/java";
		String username="root";
		String password="root";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql="select * from student";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString("stu_name");
				String email=rs.getString("email");
				String branch=rs.getString("branch");
				System.out.println(id+"-"+name+"-"+email+"-"+branch);
			}
			System.out.println("---------------------------");
			rs.absolute(3);//current position of the record
			rs.updateString(4,"MECH");
			rs.updateRow();
			int id=rs.getInt(1);
			String name=rs.getString("stu_name");
			String email=rs.getString("email");
			String branch=rs.getString("branch");
			System.out.println(id+"-"+name+"-"+email+"-"+branch);
			System.out.println("----------------------------------");
			System.out.println("navigating in backward direction");
			rs.afterLast();
			while(rs.previous()) {
			 id=rs.getInt(1);
			 name=rs.getString("stu_name");
			 email=rs.getString("email");
			 branch=rs.getString("branch");
			 System.out.println(id+"-"+name+"-"+email+"-"+branch);
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
