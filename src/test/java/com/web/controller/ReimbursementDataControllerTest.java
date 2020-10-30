package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;

import com.web.model.Reimbursement;
import com.web.repo.ReimbursementDao;
import com.web.service.ReimbursementService;
import com.web.util.SessionController;

public class ReimbursementDataControllerTest {
	private ReimbursementDataController rc;
	private SessionController sc;
	private ReimbursementDao rd;
	private ReimbursementService rs;
	List<Reimbursement> reimbursements;

	HttpServletRequest req;
	HttpServletResponse res;
	Reimbursement testReim;

	@Before
	public void setup() {
//		rs = new ReimbursementService();
//		reimbursements = rs.retrieveAllReimbursements();
//
//		req = Mockito.mock(HttpServletRequest.class);
//		res = Mockito.mock(HttpServletResponse.class);
//		rs = new ReimbursementService();
//		rd = new ReimbursementDao();
//		sc = new SessionController();
//		rc = new ReimbursementDataController();
//		testReim = new Reimbursement(101, 300, "date", "description", 1, 2, 1, 1);
	}

//	@Test
//	public void sendAllDataTest() {
//		Mockito.when(res.getWriter().println(new ObjectMapper().writeValueAsString(reimbursements))).thenReturn("/P");
//		assertTrue(rc.sendAllData(res));
//	}
}
