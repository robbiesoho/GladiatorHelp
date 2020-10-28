package com.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.web.model.User;

public class SessionController {

	public void setSession(HttpServletRequest req, User user) {
		HttpSession session = req.getSession();
		session.setAttribute("user", user);
	}

	public User getSessionUser(HttpServletRequest req) {
		return (User) req.getSession().getAttribute("user");
	}

//	better to store user objects in sessions
	public void setSessionUsername(HttpServletRequest req, String str) {
		HttpSession session = req.getSession();
		session.setAttribute("username", str);
	}

	public String getSessionUsername(HttpServletRequest req) {
		return (String) req.getSession().getAttribute("username");
	}

//	storing user objects in sessions protects passwords. This way is not secure
	public void setSessionPassword(HttpServletRequest req, String str) {
		HttpSession session = req.getSession();
		session.setAttribute("password", str);
	}

	public String getSessionPassword(HttpServletRequest req) {
		return (String) req.getSession().getAttribute("password");
	}

	public void invalidate(HttpServletRequest req) {
		req.getSession().invalidate();
	}

}
