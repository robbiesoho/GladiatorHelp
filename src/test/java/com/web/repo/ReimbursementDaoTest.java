package com.web.repo;

import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.web.model.Reimbursement;

public class ReimbursementDaoTest {
	private ReimbursementDao rd;
	private ReimbursementDao rdReal;
	Reimbursement testReim;
	List<Reimbursement> reims = new LinkedList<>();

	@Before
	public void setup() {
		rdReal = new ReimbursementDao();
		rd = Mockito.mock(ReimbursementDao.class);
		testReim = new Reimbursement(101, "validUser", "validPass", "validFirst", "validLast", "validEmail", 1, 1, 1,
				1);
		reims.add(testReim);
	}

	@Test
	public void findAllTest() {
		List<Reimbursement> Reims = rd.findAll();
		assertNotNull(Reims.size() == 0);
	}

	@Test
	public void findByIdTest() {
//		Mockito.when(rd.findById(101)).thenReturn(testReim);
		Reimbursement r = rdReal.findById(5);
		assertNotNull(r);
	}

	@Test
	public void createReimTest() {
		Mockito.when(rd.create(testReim)).thenReturn("1");
		String str = rd.create(testReim);
		assertNotNull(str);
	}

	@Test
	public void deleteReimTest() {
		Mockito.when(rd.delete(101)).thenReturn("1");
		String str = rd.delete(101);
		assertNotNull(str);
	}

	@Test
	public void approveReimbursementTest() {
		Mockito.when(rd.approveReimbursement(testReim.getId(), testReim.getAuthorId())).thenReturn("1");
		String str = rd.approveReimbursement(testReim.getId(), testReim.getAuthorId());
		assertNotNull(str);
	}

	@Test
	public void denyReimbursementTest() {
		Mockito.when(rd.denyReimbursement(testReim.getId(), testReim.getAuthorId())).thenReturn("1");
		String str = rd.denyReimbursement(testReim.getId(), testReim.getAuthorId());
		assertNotNull(str);
	}

	@Test
	public void findReimsByUserIdTest() {
		Mockito.when(rd.findReimsByUserId(testReim.getAuthorId())).thenReturn(reims);
		List<Reimbursement> rs = rd.findReimsByUserId(testReim.getAuthorId());
		assertNotNull(rs);
	}

	@Test
	public void findCompleteReimbursementsTest() {
		Mockito.when(rd.findCompleteReimbursements()).thenReturn(reims);
		List<Reimbursement> rs = rd.findCompleteReimbursements();
		assertNotNull(rs);
	}

	@Test
	public void findCompletePendingReimsTest() {
		Mockito.when(rd.findCompletePendingReims()).thenReturn(reims);
		List<Reimbursement> rs = rd.findCompletePendingReims();
		assertNotNull(rs);
	}

	@Test
	public void findReimsByUsernameTest() {
		Mockito.when(rd.findReimsByUsername("validUser")).thenReturn(reims);
		List<Reimbursement> rs = rd.findCompletePendingReims();
		assertNotNull(rs);
	}

}
