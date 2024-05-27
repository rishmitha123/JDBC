package com.codegnan.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo_02 {

	public static void main(String[] args) {
		        String driver="com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/java";
				String username="root";
				String password="root";
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

		

	}


