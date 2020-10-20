package com.web.service;

import com.web.model.Reimbursement;
import com.web.repo.DaoContract;
import com.web.repo.ReimbursementDao;

public class ReimbursementService {
	private DaoContract<Reimbursement, Integer> rdao;

	public ReimbursementService(DaoContract<Reimbursement, Integer> rdao) {
		super();
		this.rdao = rdao;
	}

	public ReimbursementService() {
		this(new ReimbursementDao());
	}
}
