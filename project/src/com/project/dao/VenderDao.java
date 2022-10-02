package com.project.dao;

import java.util.List;

import com.project.Bean.Vendor;
import com.project.exception.VendorException;

public interface VenderDao {

	
	public String registerVendor(String name,String email,String passwrod, String company, String address);

	public Vendor loginVendor(String uname, String pass) throws VendorException;
	
	public List<Vendor> getAllVendorDetail()throws VendorException;

}
