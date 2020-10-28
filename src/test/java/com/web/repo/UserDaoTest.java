package com.web.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.web.model.User;

public class UserDaoTest {
	private UserDao ud;
	User testUser;

	@Before
	public void setup() {
		ud = Mockito.mock(UserDao.class);
		testUser = new User(101, "validUser", "validPass", "validFirst", "validLast", "validEmail", 1);
	}

	@Test
	public void findAllTest() {
		List<User> users = ud.findAll();
		assertNotNull(users.size() == 0);
	}

	@Test
	public void findByIdTest() {
		Mockito.when(ud.findById(101)).thenReturn(testUser);
		User u = ud.findById(101);
		assertEquals(u.getId(), 101);
	}

	@Test
	public void createUserTest() {
		Mockito.when(ud.create(testUser)).thenReturn("1");
		String str = ud.create(testUser);
		assertNotNull(str);
	}

	@Test
	public void deleteUserTest() {
		Mockito.when(ud.delete(101)).thenReturn("1");
		String str = ud.delete(101);
		assertNotNull(str);
	}

	@Test
	public void findByNameTest() {
		Mockito.when(ud.findByName("validUser")).thenReturn(testUser);
		User u = ud.findByName("validUser");
		assertNotNull(u);
	}

}
