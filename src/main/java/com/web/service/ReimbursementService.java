package com.web.service;

import java.util.List;

import com.web.model.Reimbursement;
import com.web.repo.ReimbursementDao;

public class ReimbursementService {
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

	public List<Reimbursement> findCompleteReimbursements() {
		return rdao.findCompleteReimbursements();
	}

	public List<Reimbursement> findCompletePendingReims() {
		return rdao.findCompletePendingReims();
	}

	public List<Reimbursement> findReimsByUsername(String name) {
		return rdao.findReimsByUsername(name);
	}

	public String create(Reimbursement t) {
		return rdao.create(t);
	}

	public String delete(int id) {
		return rdao.delete(id);
	}

	public String approve(int reimId, int userId) {

		return rdao.approveReimbursement(reimId, userId);

	}

	public String deny(int reimId, int userId) {
		return rdao.denyReimbursement(reimId, userId);

	}
}
