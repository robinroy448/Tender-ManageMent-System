package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Bean.Vendor;
import com.project.exception.VendorException;
import com.project.utility.DBUtil;


public class VenderDaoImp implements VenderDao{
	
	
	@Override
	public String registerVendor(String name,String email,String passwrod, String company, String address) {
		
		String message = "Not Registerd..";
		
         try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					
					("insert into vendor(vid,name,email,password,company,address) values(?,?,?,?,?,?)");
			
			ps.setString(1, null);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, passwrod);
			ps.setString(5, company);
			ps.setString(6, address);
			
			int x= ps.executeUpdate();
			
			if(x > 0)
				message = "Vendor Registered Sucessfully !";
			
		} catch (SQLException e) {
			message = e.getMessage();
		}	
		return message;
	}
	
	@Override
     public Vendor loginVendor(String username, String password) throws VendorException {
		
		Vendor ven = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from Vendor where email = ? AND password = ?");			
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
				if(rs.next()) {
				
			    String i = rs.getString("vid");	
				String n= rs.getString("name");
				String e= rs.getString("email");
				String p= rs.getString("password");
				String c= rs.getString("company");
				String a= rs.getString("address");
				
			ven =new Vendor(i, n, e, p, c, a);		
				
			}else
				throw new VendorException("Invalid Username or password.. ");
			
			
		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		return ven;	
	}

     @Override
 	public List<Vendor> getAllVendorDetail() throws VendorException {
 		
 		List<Vendor> vendorList=new ArrayList<>();
 		
 		try (Connection con=DBUtil.provideConnection()){
 			
 			PreparedStatement ps=con.prepareStatement("select * from vendor");
 			
 			ResultSet rs=ps.executeQuery();
 			
 			while(rs.next())
 			{
 				String vi=rs.getString("vid");
 				String n=rs.getString("name");
 				String e=rs.getString("email");
 				String p=rs.getString("password");
 				String c=rs.getString("company");
 				String a=rs.getString("address");
 				
 				Vendor vendor=new Vendor(vi, n, e, p, c, a);
 				
 				vendorList.add(vendor);
 			}
 			
 		} catch (Exception e) {
 			throw new VendorException(e.getMessage());
 		}
 		
 		
 		if(vendorList.size()==0)
 		{
 			throw new VendorException("No Vendor found...");	
 		}
 		
 		
 		return vendorList;
 	}
}
