package com.cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cab.entity.CabBooking;

@Repository
public interface CabRepository extends JpaRepository<CabBooking,Integer>{
	

}

