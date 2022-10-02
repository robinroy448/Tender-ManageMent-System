package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Bean.Tender;
import com.project.exception.TenderException;
import com.project.utility.DBUtil;

public class TenderDaoImp implements TenderDao{

	@Override
		public String registerTendor(String tname, String type, String price, String deadline, String location) {
		
		String message = "Not Registerd..";
		
        try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					
					("insert into Tender(tid,tname,type,price,deadline_in_days,location) values(?,?,?,?,?,?)");
			
			ps.setString(1, null);
			ps.setString(2, tname);
			ps.setString(3, type);
			ps.setString(4, price);
			ps.setString(5, deadline);
			ps.setString(6, location);
			
			int x= ps.executeUpdate();
			
			if(x > 0)
				message = "Tendor Registered Sucessfully !";
			
		} catch (SQLException e) {
			message = e.getMessage();
		}	
		return message;
	}
	
	  @Override
	 	public List<Tender> getAllTendorDetail() throws TenderException {
	 		
	 		List<Tender> vendorList=new ArrayList<>();
	 		
	 		try (Connection con=DBUtil.provideConnection()){
	 			
	 			PreparedStatement ps=con.prepareStatement("select * from tender");
	 			
	 			ResultSet rs=ps.executeQuery();
	 			
	 			while(rs.next())
	 			{
	 				int vi=rs.getInt("tid");
	 				String n=rs.getString("tname");
	 				String e=rs.getString("type");
	 				String p=rs.getString("price");
	 				String c=rs.getString("deadline_in_days");
	 				String a=rs.getString("location");
	 				
	 				Tender tendor=new Tender(vi, n, e, p, c, a);
	 				
	 				vendorList.add(tendor);
	 			}
	 			
	 		} catch (Exception e) {
	 			throw new TenderException(e.getMessage());
	 		}
	 		
	 		
	 		if(vendorList.size()==0)
	 		{
	 			throw new TenderException("No Tendor found...");	
	 		}
	 		
	 		
	 		return vendorList;
	 	}

}
