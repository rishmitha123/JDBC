package com.codegnan.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo_08 {

	public static void main(String[] args) {
		 String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/java";
			String username="root";
			String password="root";
			try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt=con.createStatement();
				con.setAutoCommit(false);
				String sql="insert into student values(108,'anusha','anusha@gmail.com','civil')";
				int noRec=stmt.executeUpdate(sql);
				if(noRec==1) {
					System.out.println("inserted successfully");
				}
				else {
					//nothing to do
				}
				
				con.commit();
				stmt.close();
				con.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}



	}

}
