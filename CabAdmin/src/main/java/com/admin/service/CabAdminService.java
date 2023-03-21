package com.admin.service;

import java.util.List;

import com.admin.entity.CabAdmin;

public interface CabAdminService {

	    CabAdmin addCabSearchDetails(CabAdmin cabAdmin);
		
		List<CabAdmin> getAllCabs();
		
		CabAdmin getByAdminId(Integer adminId);
		
		String deleteAllCabs();
		
		String deleteCabByAdminId(Integer adminId);
		
		CabAdmin findByLocation(String location);


}
