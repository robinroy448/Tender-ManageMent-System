package com.project.useCase;

import java.util.Scanner;
import com.project.Bean.Vendor;
import com.project.dao.VenderDao;
import com.project.dao.VenderDaoImp;
import com.project.exception.VendorException;

public class VendorLoginUseCase {

private static final String String = null;

public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email:");
		String uname=sc.next();
		
		System.out.println("Enter Password:");
		String pass=sc.next();
		
       VenderDao dao = new VenderDaoImp();
		
		try {
			
			Vendor ven= dao.loginVendor(uname, pass);
	 		System.out.println("Welcome Vendor :"+ven.getVname());
	 		
	 		String id = ven.getVid();
	 		String name = ven.getVname();
	 		
	 		System.out.println("1 : show Tenders");
	 		System.out.println("2 : View Assign List");
	 		int a = sc.nextInt();
	 		
	 		
	 		if(a==1) {
	 			ViewAllTendersUseCases.main(args);
	 			
	 			System.out.println("If You Want To Apply For Tendor Enter 1;");
	 			int b = sc.nextInt();
	 	     if(b==1) {
	 			ApplyForTender.main(id,name);
	 		}else {
	 			System.out.println("Wrong Input");
	 		}
	 		}
	 		else if(a==2) {
	 			AssignBids.main(args);
	 		}
	 		else {
	 			System.out.println("Wrong Input");
	 		}
	 	
		}catch (VendorException e) {
			System.out.println(e.getMessage());
			main(args);
		}
	}
}
