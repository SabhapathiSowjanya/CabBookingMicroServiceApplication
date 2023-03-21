package com.cab.service;

import java.util.List;

import com.cab.entity.CabBooking;

public interface CabService {
	
	CabBooking addCabDetails(CabBooking cab);
	
	List<CabBooking> getAllCabs();
	
	CabBooking getByCabId(Integer cabId);
	
	String deleteAllCabs();
	
	String deleteCabById(Integer cabId);


}
