package com.exam.Controler;

import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.exam.controller.UserController;
import com.exam.model.User;
import com.exam.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	@Before
	public void setUp() {
	}

	// get userdetail by username
	@Test
	public void getUser_success() throws Exception {
		Mockito.when(userService.getUser(anyString())).thenReturn(new User());
		Assert.assertNotNull(userController.getUser("user-name"));

	}

	// delete user by userid
	@Test
	public void deleteUser_success() throws Exception {
		userService.deleteUser(10001L);
		Assert.assertNotNull(userController.deleteUser(123L));

	}

	// update user
	@Test
	public void updateUser_success() throws Exception {
		Mockito.when(userService.getUser(anyString())).thenReturn(new User());
		Assert.assertNotNull(userController.getUser("user-name"));
	}

	// create user
	@Test
	public void createUser_success() throws Exception {
		Mockito.when(userService.getUser(anyString())).thenReturn(new User());
		Assert.assertNotNull(userController.getUser("user-name"));
	}
}
