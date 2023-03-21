package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.entity.CabAdmin;
import com.admin.exception.AdminIdNotFoundException;
import com.admin.repository.CabAdminRepository;

@Service
public class CabAdminServiceImp implements CabAdminService {

	@Autowired
	CabAdminRepository cabAdminRepo;

	@Override
	public CabAdmin addCabSearchDetails(CabAdmin cabAdmin) {
		return cabAdminRepo.save(cabAdmin);
		
	}

	@Override
	public List<CabAdmin> getAllCabs() {
		return (List<CabAdmin>)cabAdminRepo.findAll();
	}

	@Override
	public CabAdmin getByAdminId(Integer adminId) {
		CabAdmin cab = cabAdminRepo.findById(adminId).orElseThrow(()-> new AdminIdNotFoundException());
		return cab;
	}
	
	

	@Override
	public String deleteAllCabs() {
		cabAdminRepo.deleteAll();
		return "All Cabs deleted";
	}

	@Override
	public String deleteCabByAdminId(Integer adminId) {
		cabAdminRepo.deleteById(adminId);	
		return "Deleted Successfully";
	}
	
	@Override
	public CabAdmin findByLocation(String location) {
			return cabAdminRepo.findByLocation(location);
	}
	
}

