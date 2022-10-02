package com.project.dao;

import java.util.List;
import com.project.Bean.Tender;
import com.project.exception.TenderException;

public interface TenderDao {




	public String registerTendor(String tname, String type, String price, String deadline, String location);

	public List<Tender> getAllTendorDetail() throws TenderException;
	
}
