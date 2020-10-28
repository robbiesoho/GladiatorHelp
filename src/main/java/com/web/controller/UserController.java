package com.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.web.model.User;
import com.web.repo.UserDao;
import com.web.service.UserService;
import com.web.util.SessionController;

public class UserController {

	private UserService us;
	private SessionController sc;
	static Logger log = Logger.getLogger(UserDao.class);

	public UserController(UserService us, SessionController sc) {
		super();
		this.us = us;
		this.sc = sc;
	}

	public UserController() {
		this(new UserService(), new SessionController());
	}

	public String login(HttpServletRequest req) {

//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
		String username = sc.getSessionUsername(req);
		String password = sc.getSessionPassword(req);

		try {
			if (us.validateCredentials(username, password)) {

				if (us.isManager(username)) {
//					return "html/manager/main.html";
					return goToManagerMain(req);

				} else {
//					return "html/gladiator/main.html";
					return goToUserMain(req);
				}
			} else {
				sc.invalidate(req);
				return "asd.page";
			}
		} catch (Exception e) {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			log.error(formatter.format(date) + " --- exception loggin in user ---" + e.getMessage());
			return "asd.page";

		}
	}

	public String goToUserMain(HttpServletRequest req) {
		return "html/gladiator/main.html";
	}

	public String goToManagerMain(HttpServletRequest req) {
		return "html/manager/main.html";
	}

	public String goToNewUserPage(HttpServletRequest req) {
		return "html/manager/newUser.html";
	}

	public String create(HttpServletRequest req) {
		String username = req.getParameter("newusername");
		String password = req.getParameter("password");
		String first = req.getParameter("first");
		String last = req.getParameter("last");
		String email = req.getParameter("email");
		int roleId = 1;
		User user = new User(username, password, first, last, email, roleId);

		us.create(user);

		return "html/manager/main.html";
	}

}
