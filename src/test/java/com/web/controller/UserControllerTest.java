package com.web.controller;

import static org.junit.Assert.assertNotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.web.model.User;
import com.web.repo.UserDao;
import com.web.util.SessionController;

public class UserControllerTest {
	private UserController uc;
	private SessionController sc;
	private UserDao ud;
	HttpServletRequest req;
	HttpServletResponse res;
	User testUser;

	@Before
	public void setup() {
		req = Mockito.mock(HttpServletRequest.class);
		res = Mockito.mock(HttpServletResponse.class);
//		sc = Mockito.mock(SessionController.class);
		ud = new UserDao();
		sc = new SessionController();
		uc = new UserController();
		testUser = new User(101, "validUser", "validPass", "validFirst", "validLast", "validEmail", 1);
	}

//	@Test
//	public void loginTest() {
//		Mockito.when(sc.getSessionUsername(req)).thenReturn("testUser");
//		Mockito.when(sc.getSessionPassword(req)).thenReturn("pass");
//		assertNull(uc.login(req));
//
//	}

	@Test
	public void goToUserMainTest() {
		assertNotNull(uc.goToUserMain(req));

	}

	@Test
	public void goToManagerMainTest() {
		assertNotNull(uc.goToManagerMain(req));

	}

	@Test
	public void goToNewUserPageTest() {
		assertNotNull(uc.goToNewUserPage(req));

	}

	@Test
	public void createTest() {
		Mockito.when(req.getParameter("newusername")).thenReturn("createUCUser");
		Mockito.when(req.getParameter("password")).thenReturn("pass");
		Mockito.when(req.getParameter("first")).thenReturn("pass");
		Mockito.when(req.getParameter("last")).thenReturn("pass");
		Mockito.when(req.getParameter("email")).thenReturn("createUCUser@asdf.com");
		Mockito.when(req.getParameter("email")).thenReturn("createUCUser@asdf.com");
		assertNotNull(uc.create(req));

		User killMe = ud.findByName("createUCUser");
		ud.delete(killMe.getId());

	}

//	@Test
//	public void logoutTest() {
//		Mockito.when(sc.invalidate(req)).thenReturn("1");
//
//		assertNotNull(uc.logout(req));
//	}

}
