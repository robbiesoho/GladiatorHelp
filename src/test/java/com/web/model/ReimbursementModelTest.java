package com.web.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ReimbursementModelTest {

	Reimbursement testReim;
	Reimbursement testReim2;

	@Before
	public void setup() {
		testReim = new Reimbursement(101, 300, "date", "description", 1, 2, 1, 1);
//		to test a different constructor
		testReim2 = new Reimbursement("type", "status", "user");

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
