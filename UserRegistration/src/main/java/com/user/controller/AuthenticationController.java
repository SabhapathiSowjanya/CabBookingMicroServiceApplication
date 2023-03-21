package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.UserRegister;
import com.user.jwt.JwtUtills;
import com.user.security.UserLoginDetails;
import com.user.security.UserLoginDetailsService;
import com.user.service.UserServiceImp;

@RestController
@RequestMapping(value = "/userRegister/auth")
public class AuthenticationController {
	@Autowired
	private UserLoginDetailsService userLoginDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtills jwtUtills;
	
	@Autowired
	private UserServiceImp userService;
	
	
	@PostMapping(value = "/authentication")
	public ResponseEntity<String> authenticated(@RequestBody UserRegister userRegister) {
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRegister.getUserName(), userRegister.getUserPassword()));
		System.out.println("++++Passed+++++");
		if(authentication.isAuthenticated()) {
			UserLoginDetails customerLoginDetails = (UserLoginDetails) userLoginDetailsService.loadUserByUsername(userRegister.getUserName());
			String token = jwtUtills.generateJwtToken(customerLoginDetails);
			return ResponseEntity.ok(token);
		}
		
		return userService.notAutherizedMessage();
		
	}
	

}
