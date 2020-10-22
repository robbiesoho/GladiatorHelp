package com.web.service;

import java.util.List;

import com.web.model.Reimbursement;
import com.web.model.User;
import com.web.repo.DaoContract;
import com.web.repo.ReimbursementDao;

public class ReimbursementService {
//	private DaoContract<Reimbursement, Integer> rdao;
	private ReimbursementDao rdao;

	public ReimbursementService(ReimbursementDao rdao) {
		super();
		this.rdao = rdao;
	}

	public ReimbursementService() {
		this(new ReimbursementDao());
	}

	public List<Reimbursement> retrieveAllReimbursements() {
		return rdao.findAll();
	}

	public List<Reimbursement> retrieveReimbursementsByUserId(Integer id) {
		return rdao.findReimsByUserId(id);
	}
}
