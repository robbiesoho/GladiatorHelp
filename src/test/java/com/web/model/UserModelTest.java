package com.web.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class UserModelTest {

	User testUser;
	User testUser2;
	User testUser3;
	User testUser4;

	@Before
	public void setup() {
		testUser = new User(101, "validUser", "validPass", "validFirst", "validLast", "validEmail", 1);
		testUser2 = new User("validUser2", "validPass", "validFirst", "validLast", "validEmail", 1);
		testUser3 = new User("validUser3", "validPass");
		testUser4 = new User();

	}

	@Test
	public void constructor2Test() {

		assertNotNull(testUser2);
	}

	@Test
	public void constructor3Test() {

		assertNotNull(testUser3);
	}

	@Test
	public void constructor4Test() {

		assertNotNull(testUser4);
	}

	@Test
	public void getIdTest() {
		int id = testUser.getId();
		assertEquals(id, 101);
	}

	@Test
	public void getUsernameTest() {
		String name = testUser.getUsername();
		assertEquals(name, "validUser");
	}

	@Test
	public void getPasswordTest() {
		String pass = testUser.getPassword();
		assertEquals(pass, "validPass");
	}

	@Test
	public void getFirstNameTest() {
		String first = testUser.getFirstName();
		assertEquals(first, "validFirst");
	}

	@Test
	public void getLastNameTest() {
		String last = testUser.getLastName();
		assertEquals(last, "validLast");
	}

	@Test
	public void getEmailTest() {
		String email = testUser.getEmail();
		assertEquals(email, "validEmail");
	}

	@Test
	public void getRoleIdTest() {
		int id = testUser.getRoleId();
		assertEquals(id, 1);
	}

}
