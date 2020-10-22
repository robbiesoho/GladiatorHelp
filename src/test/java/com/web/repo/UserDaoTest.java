package com.web.repo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.web.model.User;

public class UserDaoTest {
	private UserDao ud;

	@Before
	public void setup() {
		ud = new UserDao();
	}

	@Test
	public void findAllTest() {
		List<User> users = ud.findAll();
		assertFalse(users.size() == 0);
	}

	@Test
	public void findByIdTest() {
		User u = ud.findById(1);
		assertNotNull(u);
	}

	@Test
	public void findByNameTest() {
		User u = ud.findByName("testUser");
		assertNotNull(u);
	}

}
