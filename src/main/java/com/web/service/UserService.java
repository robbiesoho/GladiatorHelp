package com.web.service;

import com.web.model.User;
import com.web.repo.DaoContract;
import com.web.repo.UserDao;

public class UserService {
	private DaoContract<User, Integer> udao;

	public UserService(DaoContract<User, Integer> udao) {
		super();
		this.udao = udao;
	}

	public UserService() {
		this(new UserDao());
	}

}
