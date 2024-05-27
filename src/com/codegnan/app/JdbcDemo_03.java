package com.codegnan.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo_03 {

	public static void main(String[] args) {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/java";
		String username="root";
		String password="root";
		Scanner sc=new Scanner(System.in);
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
			Connection con=DriverManager.getConnection(url, username, password);
			Statement stmt=con.createStatement();
			//update student set stu_name="anju" where stu_id=105
			String sql="UPDATE STUDENT SET stu_name='"+name+"',email='"+email+"',branch='"+branch+"' where stu_id= "+id;  
					
			int noRec=stmt.executeUpdate(sql);
			if(noRec==1) {
				System.out.println("updated successfully");
			}
			else {
				System.out.println("invalid id to update student data");
				
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
