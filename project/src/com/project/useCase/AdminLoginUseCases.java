package com.project.useCase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.project.Bean.Admin;
import com.project.exception.AdminException;

import com.project.utility.DBUtil;

public class AdminLoginUseCases {

	public static void main(String[] args)throws AdminException {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email:");
		String email=sc.next();
		
		System.out.println("Enter Password:");
		String pass=sc.next();
		
		Admin ad = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from admin where email = ? AND password = ?");			
			
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs= ps.executeQuery();
			
				if(rs.next()) {
				
			    int i = rs.getInt("aid");	
				String n= rs.getString("name");
				String e= rs.getString("email");
				String p= rs.getString("password");
				
			ad =new Admin(i, n, e, p);		
			
			System.out.println("Welcome Admin :"+ad.getAname());
			
			System.out.println("1 : Registor A Vender");
			System.out.println("2 : Add A Tender");
			System.out.println("3 : Remove A Tender");
			System.out.println("4 : Show All Venders");
			System.out.println("5 : Show All Tenders");
			System.out.println("6 : Show All Bidders");
			
			
			int a =sc.nextInt();
			
			if(a==1){
				RegisterVendorUseCase.main(args);
			}else if(a==2){
				CreateTenderUseCases.main(args);
			}else if(a==3){
				
			}else if(a==4){
				ViewAllVendor.main(args);
			}else if(a==5){
				ViewAllTendersUseCases.main(args);
			}else if(a==6){
				ViewAllBidder.main(args);
			}else{
				System.out.println("Wrong Input");
			}

			
				
			}else
				throw new AdminException("Invalid Username or password.. ");
			
			
			
		} catch (SQLException e) {
			throw new AdminException(e.getMessage());
		}
		

	}

}
