package com.web.servlet;

import javax.servlet.http.HttpServletRequest;

public class RequestForwarder {

	public String routes(HttpServletRequest req) {
		switch (req.getRequestURI()) {
//		case "/HallowsMonsters/login.page":
//			return new MonsterController().login(req);
		default:
			return "html/index.html";
		}
	}
}
