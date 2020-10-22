package com.web.service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.web.model.User;
import com.web.repo.DaoContract;
import com.web.repo.UserDao;
import com.web.util.MD5Utils;

public class UserService {
	private static final Charset UTF_8 = StandardCharsets.UTF_8;
	private static final String OUTPUT_FORMAT = "%-20s:%s";

	private DaoContract<User, Integer> udao;

	private MD5Utils md5;

	public UserService(DaoContract<User, Integer> udao) {
		super();
		this.udao = udao;
	}

	public UserService() {
		this(new UserDao());
	}

	public boolean validateCredentials(String username, String password) {
		User user = udao.findByName(username);

		byte[] md5InBytes = MD5Utils.digest(password.getBytes(UTF_8));

		String md5Pass = MD5Utils.bytesToHex(md5InBytes);

		if (user.getPassword().equals(md5Pass)) {
			return true;
		} else {
			return false;
		}
	}

}
