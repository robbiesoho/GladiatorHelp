package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "views", urlPatterns = { "*.page" })
public class ViewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Cookie cookieUser = new Cookie("username", req.getParameter("username"));
//		cookieUser.setMaxAge(-1);
//		resp.addCookie(cookieUser);

		req.getRequestDispatcher(new RequestForwarder().routes(req)).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session = req.getSession(true);
		HttpSession session = req.getSession();
		session.setAttribute("username", req.getParameter("username"));
		session.setAttribute("password", req.getParameter("password"));

		Cookie cookieUser = new Cookie("username", req.getParameter("username"));
//		cookieUser.setMaxAge(60);
//		cookieUser.setPath("deleteReimbursement.page");
		resp.addCookie(cookieUser);
//		Cookie cookiePass = new Cookie("password", req.getParameter("password"));

//		resp.addCookie(cookiePass);

		req.getRequestDispatcher(new RequestForwarder().routes(req)).forward(req, resp);

	}
}
