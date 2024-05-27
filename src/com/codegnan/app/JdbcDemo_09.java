package com.codegnan.app;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcDemo_09 {

	public static void main(String[] args) {
		Properties props=new Properties();
		try {
			props.load(new FileInputStream("db.properties"));
		
			String driver=props.getProperty("driver");
			String url=props.getProperty("url");
			String username=props.getProperty("username");
			String password=props.getProperty("password");
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt=con.createStatement();
			String sql="select * from student";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString("stu_name");
				String email=rs.getString("email");
				String branch=rs.getString("branch");
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
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}

}
