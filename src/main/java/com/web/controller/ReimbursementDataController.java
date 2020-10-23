package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.model.Reimbursement;
import com.web.service.ReimbursementService;

public class ReimbursementDataController {
	private ReimbursementService rs;

	public ReimbursementDataController(ReimbursementService rs) {
		super();
		this.rs = rs;
	}

	public ReimbursementDataController() {
		this(new ReimbursementService());
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

}