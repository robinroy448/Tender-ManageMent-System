package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Bean.bidder;
import com.project.utility.DBUtil;

public class BidderDaoImp implements BidderDao{

	@Override
	 public String acceptBid(int vid,String vname,String tid,int price, String deadline){
		
		String message = "Bid Acceptance Failed";
		
		  try(Connection conn= DBUtil.provideConnection()) {
			  
			  PreparedStatement ps= conn.prepareStatement
						
						("insert into bidder(vid,vname,tid,price,deadline_in_days) values(?,?,?,?,?)");
				
				ps.setInt(1, vid);
				ps.setString(2, vname);
				ps.setString(3, tid);
				ps.setInt(4, price);
				ps.setString(5, deadline);
								
				int x= ps.executeUpdate();
				
				if(x > 0)
					message = "Bid Registered Sucessfully !";
				
			} catch (SQLException e) {
				message = e.getMessage();
			}	
			return message;
	
	}
	
	public List<bidder> getAllBidderDetail() throws Exception {
 		
 		List<bidder> bidderList=new ArrayList<>();
 		
 		try (Connection con=DBUtil.provideConnection()){
 			
 			PreparedStatement ps=con.prepareStatement("select * from bidder");
 			
 			ResultSet rs=ps.executeQuery();
 			
 			while(rs.next())
 			{
 				int vi=rs.getInt("vid");
 				String n=rs.getString("vname");
 				String e=rs.getString("tid");
 				int p=rs.getInt("price");
 				String c=rs.getString("deadline_in_days");
 				
 				bidder vendor=new bidder(vi, n, e, p, c);
 				
 				bidderList.add(vendor);
 			}
 			
 		} catch (Exception e) {
 			throw new Exception(e.getMessage());
 		}
 		
 		
 		if(bidderList.size()==0)
 		{
 			throw new Exception("No Bidder found...");	
 		}
 		
 		
 		return bidderList;
 	}
	
       public List<bidder> assignBids() throws Exception {
 		
 		List<bidder> assignList=new ArrayList<>();
 		
 		try (Connection con=DBUtil.provideConnection()){
 			
 			PreparedStatement ps=con.prepareStatement("SELECT vid, vname, tid, price, deadline_in_days FROM bidder WHERE (tid,price) IN (SELECT tid, min(price) FROM bidder GROUP BY tid);");
 			
 			ResultSet rs=ps.executeQuery();
 			
 			while(rs.next())
 			{
 				int vi=rs.getInt("vid");
 				String n=rs.getString("vname");
 				String e=rs.getString("tid");
 				int p=rs.getInt("price");
 				String c=rs.getString("deadline_in_days");
 				
 				bidder vendor=new bidder(vi, n, e, p, c);
 				
 				assignList.add(vendor);
 			}
 			
 		} catch (Exception e) {
 			throw new Exception(e.getMessage());
 		}
 		
 		
 		if(assignList.size()==0)
 		{
 			throw new Exception("No List found...");	
 		}
 		
 		
 		return assignList;
 	}

	
	}

