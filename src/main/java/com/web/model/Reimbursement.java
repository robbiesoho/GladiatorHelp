package com.web.model;

import java.time.LocalDateTime;

public class Reimbursement {
	private int id;
	private int amount;
	private String submitted;
	private LocalDateTime resolved;
	private String description;
	private byte[] reciept;
	private int authorId;
	private int resolverId;
	private int statusId;
	private int typeId;
	private String status;
	private String type;
	private String username;

	public Reimbursement(int id, int amount, String submitted, LocalDateTime resolved, String description,
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

	public Reimbursement(int id, int amount, String submitted, String description, byte[] reciept, int authorId,
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

	public Reimbursement(int id, int amount, String submitted, String description, int authorId, int resolverId,
			int statusId, int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

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

	public Reimbursement(int id, String username, String submitted, String description, String status, String type,
			int amount) {
		super();
		this.id = id;
		this.setUsername(username);
		this.submitted = submitted;
		this.description = description;
		this.status = status;
		this.type = type;
		this.amount = amount;

	}

	public Reimbursement(int id, String username, String submitted, String description, String status, String type,
			int amount, int authorId, int statusId, int typeId) {
		super();
		this.id = id;
		this.setUsername(username);
		this.submitted = submitted;
		this.description = description;
		this.status = status;
		this.type = type;
		this.amount = amount;
		this.authorId = authorId;
		this.statusId = statusId;
		this.typeId = typeId;

	}

	public Reimbursement(String username, String description, String status, int amount) {
		super();
		this.setUsername(username);
		this.description = description;
		this.status = status;
		this.amount = amount;

	}

	public Reimbursement(int authorId, int amount, String description, int typeId, int statusId) {
		super();
		this.authorId = authorId;
		this.amount = amount;
		this.description = description;
		this.typeId = typeId;
		this.statusId = statusId;

	}

	public Reimbursement(String type, String status, String username) {
		super();
		this.type = type;
		this.status = status;
		this.username = username;

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
