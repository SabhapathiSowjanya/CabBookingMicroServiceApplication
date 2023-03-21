package com.admin.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.entity.CabAdmin;

@Repository
public interface CabAdminRepository extends JpaRepository<CabAdmin,Integer> {

	CabAdmin findByLocation(String location);

}
