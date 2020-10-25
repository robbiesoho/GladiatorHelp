package com.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.web.model.Reimbursement;
import com.web.model.User;
import com.web.repo.UserDao;
import com.web.service.ReimbursementService;

public class ReimbursementController {
	private UserDao udao;
	private ReimbursementService rs;

	public ReimbursementController(ReimbursementService rs, UserDao udao) {
		super();
		this.udao = udao;
		this.rs = rs;
	}

	public ReimbursementController() {
		this(new ReimbursementService(), new UserDao());
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

		int statusId = 1;

		Reimbursement reimbursement = new Reimbursement(userId, amount, description, typeId, statusId);

		rs.create(reimbursement);

		return "html/gladiator/main.html";

	}

	public String delete(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		rs.delete(id);
		return "html/gladiator/main.html";
	}
}
