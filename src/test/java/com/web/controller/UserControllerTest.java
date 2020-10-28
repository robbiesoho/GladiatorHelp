package com.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.mockito.Mockito;

import com.web.model.User;
import com.web.util.SessionController;

public class UserControllerTest {
	private UserController uc;
	private SessionController sc;
	HttpServletRequest req;
	HttpServletResponse res;
	User testUser;

	@Before
	public void setup() {
		req = Mockito.mock(HttpServletRequest.class);
		res = Mockito.mock(HttpServletResponse.class);
		sc = Mockito.mock(SessionController.class);
		uc = new UserController();
		testUser = new User(101, "validUser", "validPass", "validFirst", "validLast", "validEmail", 1);
	}

//	@Test
//	public void loginTest() {
//		Mockito.when(uc.login(req)).thenReturn("1");
//		assertEquals(uc.login(req), "1");
//
//	}

}
