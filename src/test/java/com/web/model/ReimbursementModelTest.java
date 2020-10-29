package com.web.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class ReimbursementModelTest {

	Reimbursement testReim;
	Reimbursement testReim2;
	Reimbursement testReim3;
	Reimbursement testReim4;
	Reimbursement testReim5;
	Reimbursement testReim6;
	byte[] byteArray = new byte[1];;

	@Before
	public void setup() {
		testReim = new Reimbursement(101, 300, "date", "description", 1, 2, 1, 1);
//		to test a different constructor
		testReim2 = new Reimbursement("type", "status", "user");
		testReim3 = new Reimbursement(1, 1, "date", LocalDateTime.now(), "desc", byteArray, 1, 2, 3, 1);
		testReim4 = new Reimbursement(1, "desc", 1, 1, 1);
		testReim5 = new Reimbursement("name", "desc", "status", 1);
		testReim6 = new Reimbursement(1, 1, "status", 1, 1);

	}

	@Test
	public void constructor3Test() {
		assertNotNull(testReim3);
	}

	@Test
	public void getResolvedTest() {
		assertNotNull(testReim3.getReciept());
	}

	@Test
	public void constructor4Test() {
		assertNotNull(testReim4);
	}

	@Test
	public void constructor5Test() {
		assertNotNull(testReim5);
	}

	@Test
	public void constructor6Test() {
		assertNotNull(testReim6);
	}

	@Test
	public void getIdTest() {
		int id = testReim.getId();
		assertEquals(id, 101);
	}

	@Test
	public void getAmountTest() {
		int amt = testReim.getAmount();
		assertEquals(amt, 300);
	}

	@Test
	public void getSubmittedTest() {
		String sub = testReim.getSubmitted();
		assertEquals(sub, "date");
	}

	@Test
	public void getDescriptionTest() {
		String des = testReim.getDescription();
		assertEquals(des, "description");
	}

	@Test
	public void getAuthorIdTest() {
		int id = testReim.getAuthorId();
		assertEquals(id, 1);
	}

	@Test
	public void getResolverIdTest() {
		int id = testReim.getResolverId();
		assertEquals(id, 2);
	}

	@Test
	public void getStatusIdTest() {
		int id = testReim.getStatusId();
		assertEquals(id, 1);
	}

	@Test
	public void getTypeIdTest() {
		int id = testReim.getTypeId();
		assertEquals(id, 1);
	}

	@Test
	public void getTypeTest() {
		String typ = testReim2.getType();
		assertEquals(typ, "type");
	}

	@Test
	public void getStatusTest() {
		String sts = testReim2.getStatus();
		assertEquals(sts, "status");
	}

	@Test
	public void getUsernameTest() {
		String usn = testReim2.getUsername();
		assertEquals(usn, "user");
	}

}
