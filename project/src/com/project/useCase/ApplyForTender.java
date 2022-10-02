package com.project.useCase;

import java.util.Scanner;

import com.project.dao.BidderDao;
import com.project.dao.BidderDaoImp;

public class ApplyForTender {

	public static void main(String id, String name) {
		// TODO Auto-generated method stub
		int i=Integer.parseInt(id);  
Scanner sc=new Scanner(System.in);

//        System.out.println("Enter vid");
//        int vid=sc.nextInt();
//
//        System.out.println("Enter name");
//        String vname=sc.next();
		
		System.out.println("Enter tid");
		String tid=sc.next();
		
		System.out.println("Price:");
		int price=sc.nextInt();
		
		System.out.println("Deadline in days:");
		String deadline=sc.next();
		
       BidderDao dao= new BidderDaoImp();
		
        String result= dao.acceptBid(i, name, tid, price, deadline);
		
		System.out.println(result);
		
	}
}
