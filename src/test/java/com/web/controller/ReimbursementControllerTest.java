package com.web.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.web.model.User;
import com.web.repo.UserDao;
import com.web.service.ReimbursementService;
import com.web.util.SessionController;

public class ReimbursementControllerTest {

	private ReimbursementController rc;
	private UserDao udao;
	private ReimbursementService rs;
	private SessionController sc;

	@Before
	public void setup() {
		rs = Mockito.mock(ReimbursementService.class);

		udao = Mockito.mock(UserDao.class);
		sc = Mockito.mock(SessionController.class);

		rc = new ReimbursementController(rs, udao, sc);
	}

	@Test
	public void testGetIdFromName() {
		Mockito.when(udao.findByName("name")).thenReturn(new User(1));
		int id = rc.getIdFromUsername("name");
		assertEquals(id, 1);
	}
//	@Test
//	public void testGoToNewClaimPage() {
//		Mockito.when(rc.findByName("name")).thenReturn(new User(1));
//		int id = rc.getIdFromUsername("name");
//		assertEquals(id, 1);
//	}

//	@Test
//	public void testCreate() {
//		Mockito.when(rc.)).thenReturn(new User(1));
//		int id = rc.getIdFromUsername("name");
//		assertEquals(id, 1);
//	}
//	
//	@Test
//	public void testCreate() {
//		Mockito.when(rc.)).thenReturn(new User(1));
//		int id = rc.getIdFromUsername("name");
//		assertEquals(id, 1);
//	}

}
