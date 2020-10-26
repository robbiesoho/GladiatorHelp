package com.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.web.model.User;
import com.web.repo.UserDao;
import com.web.service.UserService;

public class UserController {

	private UserService us;
	static Logger log = Logger.getLogger(UserDao.class);

	public UserController(UserService us) {
		super();
		this.us = us;
	}

	public UserController() {
		this(new UserService());
	}

	public String login(HttpServletRequest req) {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		try {
			if (us.validateCredentials(username, password)) {
				if (us.isManager(username)) {
					return "html/manager/main.html";

				} else {
					return "html/gladiator/main.html";
				}
			} else {
				return "asd.page";
			}
		} catch (Exception e) {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			log.error(formatter.format(date) + " --- exception loggin in user ---" + e.getMessage());
			return "asd.page";

		}
	}

	public String goToNewUserPage(HttpServletRequest req) {
		return "html/manager/newUser.html";
	}

	public String create(HttpServletRequest req) {
//		gotta make constructor and make new user
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String first = req.getParameter("first");
		String last = req.getParameter("last");
		String email = req.getParameter("email");

		User user = new User();

		us.create(user);

		return "html/gladiator/main.html";
	}

}
