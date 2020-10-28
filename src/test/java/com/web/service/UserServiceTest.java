package com.web.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.web.model.User;
import com.web.repo.UserDao;

public class UserServiceTest {

	private UserDao ud;
	private UserService us;
	User testUser;

	@Before
	public void setup() {
		ud = Mockito.mock(UserDao.class);
		us = new UserService();
		testUser = new User(101, "validUser", "validPass", "validFirst", "validLast", "validEmail", 1);
	}

	@Test
	public void verifyLoginCredsTest() {
		boolean checkStatus = us.validateCredentials("testUser", "pass");
		assertTrue(checkStatus);

	}

	@Test
	public void checkIfManagerTest() {
		boolean checkStatus = us.isManager("testManager");
		assertTrue(checkStatus);

	}

	@Test
	public void createUserTest() {
		String str = us.create(testUser);
		assertNull(str);

	}

	@After
	public void cleanUpCreatedUser() {
		ud.delete(testUser.getId());
	}

}