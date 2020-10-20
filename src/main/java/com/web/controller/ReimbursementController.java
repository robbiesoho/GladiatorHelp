package com.web.controller;

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
}
