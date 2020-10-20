package com.web.model;

public class ReimbursementStatus {
	private int id;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ReimbursementStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public ReimbursementStatus() {
		super();
	}

}
