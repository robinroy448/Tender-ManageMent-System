package com.project.useCase;

import java.util.List;

import com.project.Bean.bidder;
import com.project.dao.BidderDao;
import com.project.dao.BidderDaoImp;



public class AssignBids {
	
public static void main(String[] args) {
		
		BidderDao dao=new BidderDaoImp();
		
try {
			
			List<bidder> vendors=dao.assignBids();
			
			vendors.forEach(v->{
				System.out.println("Vendor Id: "+v.getVid());
				System.out.println("Vendor Name: "+v.getName());
				System.out.println("Tid: "+v.getTid());
				System.out.println("Price: "+v.getPrice());
				System.out.println("Deadline: "+v.getDeadline());
				System.out.println();
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
