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
	private UserDao udReal;
	User testUser;

	@Before
	public void setup() {
		udReal = new UserDao();
		ud = Mockito.mock(UserDao.class);
		testUser = new User(105, "UserDaoTester", "validPass", "validFirst", "validLast", "UserDaoEmail", 1);
	}

	@Test
	public void findAllTest() {
		List<User> users = udReal.findAll();
		assertNotNull(users);
	}

	@Test
	public void findByIdTest() {
		User u = udReal.findById(1);
		assertNotNull(u);

	}

	@Test
	public void createAndDeleteUserTest() {
		List<User> users = udReal.findAll();
		int lengthBefore = users.size();
		udReal.create(testUser);
		assertEquals(udReal.findAll().size(), lengthBefore + 1);

		User testUser = udReal.findByName("UserDaoTester");
		int testId = testUser.getId();
		List<User> users2 = udReal.findAll();
		int lengthAfter = users2.size();
		udReal.delete(testId);
		assertEquals(udReal.findAll().size(), lengthAfter - 1);
	}

//	public void createUserTest() {
//		List<User> users = udReal.findAll();
//		int lengthBefore = users.size();
//		udReal.create(testUser);
//		assertEquals(udReal.findAll().size(), lengthBefore + 1);
//	}
//	
//	@Test
//	public void deleteUserTest() {
//		User testUser = udReal.findByName("UserDaoTester");
//		int testId = testUser.getId();
//		List<User> users = udReal.findAll();
//		int lengthBefore = users.size();
//		System.out.println(testId);
//		udReal.delete(testId);
//		
//		assertEquals(udReal.findAll().size(), lengthBefore - 1);
//		
//	}

	@Test
	public void findByNameTest() {
		User u = udReal.findByName("robert");
		assertNotNull(u);
	}

}
