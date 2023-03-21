package com.user.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.user.entity.UserRegister;
import com.user.repository.UserRepository;
import com.user.service.UserServiceImp;

@SpringBootTest
public class UserRegistrationTestCases {

	@Autowired
	private UserServiceImp userSer;

	@MockBean
	private UserRepository userRepo;

	@Test
	public void addUser() {
		UserRegister userRegister = new UserRegister(1, "jack", "jack2367", "9652387043", 1);
		Mockito.when(userRepo.save(userRegister)).thenReturn(userRegister);
		assertEquals(userRegister, userSer.addUser(userRegister));
	}

	@Test
	public void getAllUsers() {
		Mockito.when(userRepo.findAll()).thenReturn(Stream.of(new UserRegister(1, "jack", "jack4535", "9652387045", 1),
				new UserRegister(2, "Prem", "Prem4433", "768975677", 1)).collect(Collectors.toList()));
		assertEquals(2, userSer.getAllUsers().size());
	}

	@Test
	public void deleteUserById() {
		UserRegister user = new UserRegister(1, "sowji", "sowji38745", "9652387044", 1);
		assertEquals("Deleted Successfully", userSer.deleteUserById(user.getUserId()));
	}

	@Test
	public void deleteallUsers() {
		assertEquals("All Users deleted", userSer.deleteAllUsers());
	}

}
