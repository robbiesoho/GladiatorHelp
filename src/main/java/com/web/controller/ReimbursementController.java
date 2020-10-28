package com.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.web.model.Reimbursement;
import com.web.model.User;
import com.web.repo.UserDao;
import com.web.service.ReimbursementService;
import com.web.util.SessionController;

public class ReimbursementController {
	private UserDao udao;
	private ReimbursementService rs;
	private SessionController sc;

	public ReimbursementController(ReimbursementService rs, UserDao udao, SessionController sc) {
		super();
		this.udao = udao;
		this.rs = rs;
		this.sc = sc;
	}

	public ReimbursementController() {
		this(new ReimbursementService(), new UserDao(), new SessionController());
	}

	public String goToNewClaimPage(HttpServletRequest req) {
		return "html/gladiator/newReimbursement.html";

	}

	public int getIdFromUsername(String name) {
		User user = udao.findByName(name);
		return user.getId();
	}

	public String create(HttpServletRequest req) {

		String username = req.getParameter("username");
//		System.out.println(req.getParameter("password"));
		int userId = getIdFromUsername(username);
		int amount = Integer.parseInt(req.getParameter("amount"));
		String description = req.getParameter("description");
		int typeId = Integer.parseInt(req.getParameter("type"));

		int statusId = 2;

		Reimbursement reimbursement = new Reimbursement(userId, amount, description, typeId, statusId);

		rs.create(reimbursement);

		return "html/gladiator/main.html";

	}

	public String delete(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		rs.delete(id);
		UserController uc = new UserController();
		return uc.goToUserMain(req);
//		return "asd.page";
//		return "html/gladiator/main.html";
	}

	public String goToAllReimPage(HttpServletRequest req) {
		return "html/manager/allReimbursements.html";

	}

	public String goToPendingReimPage(HttpServletRequest req) {
		return "html/manager/pendingReimbursements.html";
	}

	public String approve(HttpServletRequest req) {
		String managerName = null;
		Cookie[] cookies = req.getCookies();
		for (Cookie c : cookies) {
			managerName = c.getValue();
		}
		System.out.println(req.getParameter("id"));
		int userId = getIdFromUsername(managerName);
		int reimId = Integer.parseInt(req.getParameter("id"));
		System.out.println(reimId);
		rs.approve(reimId, userId);
		return "html/manager/pendingReimbursements.html";
	}

	public String deny(HttpServletRequest req) {
		String managerName = null;
		Cookie[] cookies = req.getCookies();
		for (Cookie c : cookies) {
			managerName = c.getValue();
		}
		int userId = getIdFromUsername(managerName);
		int reimId = Integer.parseInt(req.getParameter("id"));
		rs.deny(reimId, userId);
		return "html/manager/pendingReimbursements.html";
	}

}
