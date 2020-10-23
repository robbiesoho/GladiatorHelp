package com.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.web.service.UserService;

public class UserController {
	private UserService us;

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
		if (us.validateCredentials(username, password)) {
			if (us.isManager(username)) {
				return "html/manager.html";
//				return "html/manager/manWelcome.html";

			} else {
				return "html/gladiator/welcome.html";

			}
		} else {
			return "html/bad.html";
		}
	}

}
