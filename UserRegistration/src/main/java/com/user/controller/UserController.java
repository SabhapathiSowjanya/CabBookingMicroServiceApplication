package com.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.APIResponse;
import com.user.entity.UserRegister;
import com.user.service.UserServiceImp;

@RestController
@RequestMapping("/userRegister")
public class UserController {

	@Autowired
	private UserServiceImp userSer;

	/*
	 * @PostMapping("/add") public UserRegister addDetails(@RequestBody UserRegister
	 * user) { UserRegister obj=userSer.addUser(user); return userSer.addUser(user);
	 * 
	 * }
	 */

	@PostMapping("/add")
	public ResponseEntity<UserRegister> addUser(@RequestBody @Valid UserRegister user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getUserPassword());
		user.setUserPassword(encodedPassword);
		return new ResponseEntity<UserRegister>(userSer.addUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserRegister>> getDetails() {
		List<UserRegister> Response = userSer.getAllUsers();
		return new ResponseEntity<List<UserRegister>>(Response, HttpStatus.OK);
	}

	@GetMapping("/getByUserId/{userId}")
	public APIResponse getUserId(@PathVariable("userId") Integer userId) {
		APIResponse user = userSer.getByUserId(userId);
		return user;

	}

	@DeleteMapping("/deleteAllUsers")
	public String deleteall() {
		return userSer.deleteAllUsers();
	}

	@DeleteMapping("/deleteUserById")
	public ResponseEntity<String> deleteUserById(@RequestParam("userId") Integer userId) {
		userSer.deleteUserById(userId);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

}
