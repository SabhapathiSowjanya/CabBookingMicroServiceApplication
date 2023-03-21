package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admin.entity.CabAdmin;
import com.admin.service.CabAdminServiceImp;

@RestController
@RequestMapping("/cabadmin")
public class CabAdminController {

	@Autowired
	CabAdminServiceImp cabAdminSer;
	
	@PostMapping("/addCab")
	public CabAdmin addCabDetails(@RequestBody CabAdmin cab)
	{

		CabAdmin addCab=cabAdminSer.addCabSearchDetails(cab);
		return cabAdminSer.addCabSearchDetails(cab);
	}
	
	@GetMapping("/getAllCabs")
	public ResponseEntity<List<CabAdmin>> getDetails()
	{
		List<CabAdmin> cabResponse =cabAdminSer.getAllCabs();
		return new ResponseEntity<List<CabAdmin>>(cabResponse,HttpStatus.OK);
	}
	
	@GetMapping("/getByAdminId/{adminId}")
	public CabAdmin getUserId(@PathVariable("adminId") Integer adminId) {
		CabAdmin cab = cabAdminSer.getByAdminId(adminId);
		return cab;
	}
	
	
	@DeleteMapping("/deleteAllCabs")
	public String deleteall() {
		return cabAdminSer.deleteAllCabs();
	}
	
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<String> deleteExpenseById(@RequestParam("adminId") Integer adminId) {
		cabAdminSer.deleteCabByAdminId(adminId);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	
	@GetMapping("/findbylocation/{location}")
	public CabAdmin getByLocation(@PathVariable String location) {
		return cabAdminSer.findByLocation(location);

	}
}
