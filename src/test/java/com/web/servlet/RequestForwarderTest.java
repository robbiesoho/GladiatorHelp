package com.web.servlet;

import static org.junit.Assert.assertNotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.web.controller.ReimbursementController;
import com.web.controller.ReimbursementDataController;
import com.web.util.SessionController;

public class RequestForwarderTest {
	private RequestForwarder rf;
	private SessionController sc;
	private ReimbursementController rc;
	private ReimbursementDataController rdc;
	HttpServletRequest req;
	HttpServletResponse res;

	@Before
	public void setup() {
		sc = new SessionController();
		rf = new RequestForwarder();
		rdc = Mockito.mock(ReimbursementDataController.class);
		rc = Mockito.mock(ReimbursementController.class);
		req = Mockito.mock(HttpServletRequest.class);
		res = Mockito.mock(HttpServletResponse.class);

	}

	@Test
	public void routes2Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1/newclaim.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes5Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1/allReimbursements.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes6Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1/pendingReimbursements.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes7Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1/approveReimbursement.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes8Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1/denyReimbursement.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes9Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1/newUser.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes10Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1/submitNewUser.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes11Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1/userMain.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes12Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1/managerMain.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes13Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1-0.0.1-SNAPSHOT/newclaim.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes14Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1-0.0.1-SNAPSHOT/allReimbursements.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes15Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1-0.0.1-SNAPSHOT/pendingReimbursements.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes16Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1-0.0.1-SNAPSHOT/approveReimbursement.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes17Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1-0.0.1-SNAPSHOT/denyReimbursement.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes18Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1-0.0.1-SNAPSHOT/newUser.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes19Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1-0.0.1-SNAPSHOT/submitNewUser.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes20Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1-0.0.1-SNAPSHOT/userMain.page");
		assertNotNull(rf.routes(req));

	}

	@Test
	public void routes21Test() {
		Mockito.when(req.getRequestURI()).thenReturn("/Project1-0.0.1-SNAPSHOT/managerMain.page");
		assertNotNull(rf.routes(req));

	}

}
