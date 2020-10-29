package com.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.mockito.Mockito;

import com.web.model.Reimbursement;
import com.web.repo.ReimbursementDao;
import com.web.util.SessionController;

public class ReimbursementDataControllerTest {
	private ReimbursementDataController rc;
	private SessionController sc;
	private ReimbursementDao rd;
	HttpServletRequest req;
	HttpServletResponse res;
	Reimbursement testReim;

	@Before
	public void setup() {
		req = Mockito.mock(HttpServletRequest.class);
		res = Mockito.mock(HttpServletResponse.class);
//		sc = Mockito.mock(SessionController.class);
		rd = new ReimbursementDao();
		sc = new SessionController();
		rc = new ReimbursementDataController();
		testReim = new Reimbursement(101, 300, "date", "description", 1, 2, 1, 1);
	}

//	@Test
//	public void sendAllDataTest() {
//		assertNotNull(rc.reimbursements);
//	}
}
