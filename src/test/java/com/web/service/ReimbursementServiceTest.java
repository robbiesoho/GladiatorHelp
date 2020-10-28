package com.web.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.web.model.Reimbursement;
import com.web.repo.ReimbursementDao;

public class ReimbursementServiceTest {
	private ReimbursementService rs;
	private ReimbursementDao rdao;

	Reimbursement testReim;

	@Before
	public void setup() {
		rdao = Mockito.mock(ReimbursementDao.class);
		rs = new ReimbursementService();
		testReim = new Reimbursement(101, "validUser", "validPass", "validFirst", "validLast", "validEmail", 1, 1, 1,
				1);

	}

	@Test
	public void retrieveAllReimbursementsTest() {
		assertNotNull(rs.retrieveAllReimbursements());
	}

	@Test
	public void retrieveReimbursementsByUserIdTest() {
		assertNotNull(rs.retrieveReimbursementsByUserId(1));
	}

	@Test
	public void findCompleteReimbursementsTest() {
		assertNotNull(rs.findCompleteReimbursements());

	}

	@Test
	public void findCompletePendingReimsTest() {
		assertNotNull(rs.findCompletePendingReims());

	}

	@Test
	public void findReimsByUsernameTest() {
		assertNotNull(rs.findReimsByUsername("rob"));

	}

	@Test
	public void createTest() {
		Mockito.when(rdao.create(testReim)).thenReturn(null);
		assertNotNull(rs.create(testReim));

	}

	@Test
	public void deleteTest() {
		Mockito.when(rdao.delete(testReim.getId())).thenReturn(null);
		assertNull(rs.delete(testReim.getId()));

	}

	@Test
	public void approveTest() {
		Mockito.when(rdao.approveReimbursement(testReim.getId(), testReim.getAuthorId())).thenReturn(null);
		assertNull(rs.approve(testReim.getId(), testReim.getAuthorId()));

	}

	@Test
	public void denyTest() {
		Mockito.when(rdao.denyReimbursement(testReim.getId(), testReim.getAuthorId())).thenReturn(null);
		assertNull(rs.deny(testReim.getId(), testReim.getAuthorId()));

	}

//	for after
	@After
	public void cleanUpCreatedReim() {
		rdao.delete(testReim.getId());
	}

}
