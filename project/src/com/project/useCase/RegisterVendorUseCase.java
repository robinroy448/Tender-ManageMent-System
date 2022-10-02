package com.project.useCase;

import java.util.Scanner;

import com.project.Bean.Vendor;
import com.project.dao.TenderDao;
import com.project.dao.TenderDaoImp;
import com.project.dao.VenderDao;
import com.project.dao.VenderDaoImp;

public class RegisterVendorUseCase {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Vendor Name:");
		String name=sc.next();
		
		System.out.println("Enter Email:");
		String email=sc.next();
		
		System.out.println("Enter Password:");
		String pass=sc.next();
		
		System.out.println("Enter Your Company:");
		String comp=sc.next();
		
		System.out.println("Enter Address:");
		String add=sc.next();
		
		
		VenderDao dao= new VenderDaoImp();
		
        String result= dao.registerVendor(name, email, pass, comp, add);
		
		System.out.println(result);
		
		

	}

}
