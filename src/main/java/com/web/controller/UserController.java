package com.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

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
//		String username;
//		String password;

//		HttpSession session = req.getSession();

		String username = req.getParameter("username");
		String password = req.getParameter("password");

//		System.out.println("parameter?");
//		System.out.println(username);
//		System.out.println("atribute?");
//		System.out.println(session.getAttribute("username"));

//		HttpSession session = req.getSession(true);

//		if (session.getAttribute("username") == null || session.getAttribute("password") == null) {
//			username = req.getParameter("username");
//			password = req.getParameter("password");
//		} else {
//			username = (String) session.getAttribute("username");
//			password = (String) session.getAttribute("password");
//		}

		try {
			if (us.validateCredentials(username, password)) {
				if (us.isManager(username)) {
					return "html/manager/manWelcome.html";

				} else {
					return "html/gladiator/main.html";
				}
			} else {
				return "html/bad.html";
			}
		} catch (Exception e) {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			log.error(formatter.format(date) + " --- exception loggin in user ---" + e.getMessage());

		}
//		if (us.validateCredentials(username, password)) {
//			if (us.isManager(username)) {
//				return "html/manager/manWelcome.html";
//
//			} else {
//				return "html/gladiator/main.html";
//			}
//		} else {
//			return "html/bad.html";
//		}
		return null;
	}

}
