package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.user.entity.APIResponse;
import com.user.entity.CabBooking;
import com.user.entity.UserRegister;
import com.user.exceptions.UserNotFoundException;
import com.user.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	
	@Autowired 
	private APIClient apiClient;
	 

	@Override
	public UserRegister addUser(UserRegister userRegister) {
		return userRepo.save(userRegister);

	}

	@Override
	public List<UserRegister> getAllUsers() {
		return (List<UserRegister>) userRepo.findAll();
	}

	@Override
	public APIResponse getByUserId(Integer userId) {
	   UserRegister user = userRepo.findById(userId).orElseThrow(()-> new UserNotFoundException());
	   
	   CabBooking cab = apiClient.getUserId(user.getCabId());
	   APIResponse response=new APIResponse(user, cab);
	   return response;
	}
	
	@Override
	public String deleteUserById(Integer userId) {
		userRepo.deleteById(userId);
		return "Deleted Successfully";
	}

	@Override
	public String deleteAllUsers() {
		userRepo.deleteAll();
		return "All Users deleted";
	}

	@Override
	public ResponseEntity<String> notAutherizedMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * @Override public ResponseEntity<String> notAutherizedMessage() throws
	 * Exception{ throw new Exception("Invalid Credentials");    }
	 */

}
