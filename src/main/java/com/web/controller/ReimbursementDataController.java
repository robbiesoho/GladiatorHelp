package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.model.Reimbursement;
import com.web.service.ReimbursementService;
import com.web.util.SessionController;

public class ReimbursementDataController {
	private ReimbursementService rs;
	SessionController sc = new SessionController();

	public ReimbursementDataController(ReimbursementService rs, SessionController sc) {
		super();
		this.rs = rs;
		this.sc = sc;
	}

	public ReimbursementDataController() {
		this(new ReimbursementService(), new SessionController());
	}

	public void sendAllData(HttpServletResponse res) {
		res.setContentType("text/json");
		List<Reimbursement> reimbursements = rs.retrieveAllReimbursements();
		try {
			res.getWriter().println(new ObjectMapper().writeValueAsString(reimbursements));
		} catch (IOException e) {
		}
	}

	public void sendCompleteReimbursements(HttpServletResponse res) {
		res.setContentType("text/json");
		List<Reimbursement> reims = rs.findCompleteReimbursements();
		try {
			res.getWriter().println(new ObjectMapper().writeValueAsString(reims));
		} catch (IOException e) {
		}
	}

	public void sendCompletePendingReimbursements(HttpServletResponse res) {
		res.setContentType("text/json");
		List<Reimbursement> reims = rs.findCompletePendingReims();
		try {
			res.getWriter().println(new ObjectMapper().writeValueAsString(reims));
		} catch (IOException e) {
		}
	}

	public void sendSessionName(HttpServletResponse res, HttpServletRequest req) {
		res.setContentType("text/json");
		String username = sc.getSessionUsername(req);
		try {
			res.getWriter().println(new ObjectMapper().writeValueAsString(username));
		} catch (IOException e) {
		}
	}

}