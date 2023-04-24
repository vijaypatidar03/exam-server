package com.exam.Controler;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;

public class UserRoleTest {

	private UserRole userRole;

	@Before
	public void setup() {
		userRole = new UserRole();
	}

	@Test
	public void testGetUserRoleid() {
		Long userRoleId = 1L;
		userRole.setUserRoleid(userRoleId);
		assertEquals(userRoleId, userRole.getUserRoleid());
	}

	@Test
	public void testGetUser() {
		User user = new User();
		userRole.setUser(user);
		assertEquals(user, userRole.getUser());
	}

	@Test
	public void testGetRole() {
		Role role = new Role();
		userRole.setRole(role);
		assertEquals(role, userRole.getRole());
	}

}
