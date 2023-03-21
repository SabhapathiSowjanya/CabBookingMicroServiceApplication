package com.cab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.entity.CabBooking;
import com.cab.exception.CabIdNotFoundException;
import com.cab.repository.CabRepository;

@Service
public class CabServiceImp implements CabService{

	@Autowired
	CabRepository cabRepo;
	
	@Override
	public CabBooking addCabDetails(CabBooking cabBooking) {
		cabBooking.setBooked(true);
		return cabRepo.save(cabBooking);
	}
	
	@Override
	public List<CabBooking> getAllCabs(){
		return (List<CabBooking>)cabRepo.findAll();
	}
	
	@Override
	public CabBooking getByCabId(Integer cabId) {
		CabBooking cab = cabRepo.findById(cabId).orElseThrow(() -> new CabIdNotFoundException());
		return cab;
	}
	
	@Override
	public String deleteAllCabs() {
		cabRepo.deleteAll();
		return "All Cabs deleted";
	}

	@Override
	public String deleteCabById(Integer cabId) {
		cabRepo.deleteById(cabId);	
		return "Deleted Successfully";
	}
	
	
}
