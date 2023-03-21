package com.user.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.user.entity.APIResponse;
import com.user.entity.UserRegister;

public interface UserService {
	

	UserRegister addUser(UserRegister userRegister);
	
	List<UserRegister> getAllUsers();
	
	APIResponse getByUserId(Integer userId);
	
	String deleteUserById(Integer userId);
	
	String deleteAllUsers();
	
	ResponseEntity<String> notAutherizedMessage();


}
