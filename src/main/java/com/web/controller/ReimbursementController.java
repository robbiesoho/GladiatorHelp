package com.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.web.service.ReimbursementService;

public class ReimbursementController {
	private ReimbursementService rs;

	public ReimbursementController(ReimbursementService rs) {
		super();
		this.rs = rs;
	}

	public ReimbursementController() {
		this(new ReimbursementService());
	}

	public String goToNewClaimPage(HttpServletRequest req) {
		System.out.println("FUCK");
		return "html/gladiator/newReimbursement.html";

	}

	public String create(HttpServletRequest req) {

		return "";
	}
}
