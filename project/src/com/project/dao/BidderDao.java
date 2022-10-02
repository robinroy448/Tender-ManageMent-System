package com.project.dao;

import java.util.List;

import com.project.Bean.bidder;

public interface BidderDao {
	

	 public String acceptBid(int vid,String vname,String tid,int price, String deadline);
	 
	 public List<bidder> getAllBidderDetail() throws Exception;
		
	 public List<bidder> assignBids() throws Exception;
		

}
