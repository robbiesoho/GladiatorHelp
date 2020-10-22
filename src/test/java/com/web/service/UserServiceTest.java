package com.web.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.web.model.User;
import com.web.repo.UserDao;

public class UserServiceTest {
	private UserService us;
	private UserDao ud;
	private User um;
	User testUser;

//	@BeforeClass
//	public static void beforeAll() {
//		System.out.println("before anything gets ran");
//	}

	@Before
	public void setup() {
		ud = Mockito.mock(UserDao.class);
		um = Mockito.mock(User.class);
		us = new UserService();
		testUser = new User("validUser", "validPass", "validFirst", "validLast", "validEmail", 1);
	}

//	@After
//	public void after() {
//		System.out.println("this is ran after every test");
//	}
//
//	@AfterClass
//	public static void afterAll() {
//		System.out.println("this is ran after everything");
//	}

	@Test
	public void verifyLoginCreds() {
		boolean checkStatus = us.validateCredentials("testUser", "pass");
		assertTrue(checkStatus);

	}

}