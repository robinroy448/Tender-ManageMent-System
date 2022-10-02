package com.project.useCase;

import java.util.Scanner;

import com.project.dao.TenderDao;
import com.project.dao.TenderDaoImp;

public class CreateTenderUseCases {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Tender Name:");
		String tname=sc.next();
		
		System.out.println("Type:");
		String type=sc.next();
		
		System.out.println("Price:");
		String price=sc.next();
		
		System.out.println("Deadline in days:");
		String deadline=sc.next();
		
		System.out.println("Enter Location:");
		String location=sc.next();
		
		
		TenderDao tdao=new TenderDaoImp();

		 String result= tdao.registerTendor(tname, type, price, deadline, location);
			
			System.out.println(result);
		
	}
}
