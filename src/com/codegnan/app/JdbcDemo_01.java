package com.codegnan.app;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Scanner;


public class JdbcDemo_01 {

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
				try{
					Class.forName(driver);
					Connection con=DriverManager.getConnection(url,username,password);
					Statement stmt=con.createStatement();
					String sql="INSERT INTO student values("+id+",'"+name+"','"+email+"','"+branch+"')";
					int noRec=stmt.executeUpdate(sql);  //we can pass insert,update and delete commands into this statement
					if(noRec==1){
						System.out.println("Inserted Succesfully");
					}
					else{
						System.out.println("Failed to Insert");
					}
					con.close();
				}
				catch(ClassNotFoundException e){
					e.printStackTrace();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
		


	}


