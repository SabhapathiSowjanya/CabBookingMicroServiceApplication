package com.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.UserRegister;

@Repository
public interface UserRepository extends JpaRepository<UserRegister, Integer>{

	List<UserRegister> findAll();

	Optional<UserRegister> findByUserId(String userId);

	Optional<UserRegister> findByUserName(String username);

	
}
