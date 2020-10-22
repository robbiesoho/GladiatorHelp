package com.web.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class ReimbursementServiceTest {
	private ReimbursementService us;

	@Before
	public void setup() {
		us = new ReimbursementService();
	}

	@Test
	public void retrieveAllReimbursementsTest() {
		assertNotNull(us.retrieveAllReimbursements());
	}

	@Test
	public void retrieveReimbursementsTestById() {
		assertNotNull(us.retrieveReimbursementsByUserId(1));

	}
}
