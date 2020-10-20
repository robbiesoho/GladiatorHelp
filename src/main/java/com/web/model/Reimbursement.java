package com.web.model;

import java.time.LocalDateTime;

public class Reimbursement {
	private int id;
	private int amount;
	private LocalDateTime submitted;
	private LocalDateTime resolved;
	private String description;
	private byte[] reciept;
	private int authorId;
	private int resolverId;
	private int statusId;
	private int typeId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDateTime getSubmitted() {
		return submitted;
	}

	public void setSubmitted(LocalDateTime submitted) {
		this.submitted = submitted;
	}

	public LocalDateTime getResolved() {
		return resolved;
	}

	public void setResolved(LocalDateTime resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getReciept() {
		return reciept;
	}

	public void setReciept(byte[] reciept) {
		this.reciept = reciept;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public Reimbursement(int id, int amount, LocalDateTime submitted, LocalDateTime resolved, String description,
			byte[] reciept, int authorId, int resolverId, int statusId, int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.reciept = reciept;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public Reimbursement(int id, int amount, LocalDateTime submitted, String description, byte[] reciept, int authorId,
			int resolverId, int statusId, int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.reciept = reciept;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

//	need a constructor iwth byte[]
	public Reimbursement(int amount, String description, int authorId, int statusId, int typeId) {
		super();
		this.amount = amount;
		this.description = description;
		this.authorId = authorId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public Reimbursement() {
		super();
	}

}
