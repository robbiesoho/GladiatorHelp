package com.web.controller;

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

}
