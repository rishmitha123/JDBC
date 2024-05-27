package com.codegnan.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcDemo_06 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/java";
		String username="root";
		String password="root";
		System.out.print("Enter id : ");
		int id=sc.nextInt();
		System.out.print("Enter Name : ");
		String name=sc.next();
        System.out.print("Enter Email : ");
        String email=sc.next();
        System.out.print("Enter Branch : ");
        String branch=sc.next();
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt=con.prepareStatement("insert into student values(?,?,?,?)");
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setString(3,email);
			pstmt.setString(4,branch);
			int noRec=pstmt.executeUpdate();
			if(noRec==1) {
				System.out.println("inserted successfully");
			}
			else {
				//nothing to do
			}
			pstmt.close();
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
