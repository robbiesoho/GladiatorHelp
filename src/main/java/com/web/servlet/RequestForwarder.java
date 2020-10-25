package com.web.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.controller.ReimbursementController;
import com.web.controller.ReimbursementDataController;
import com.web.controller.UserController;

public class RequestForwarder {

	public String routes(HttpServletRequest req) {
		switch (req.getRequestURI()) {
		case "/Project1/login.page":
			return new UserController().login(req);
		case "/Project1/newclaim.page":
			return new ReimbursementController().goToNewClaimPage(req);
		default:
			return "html/login.html";
		}
	}

	public void data(HttpServletRequest req, HttpServletResponse res) throws IOException {
		switch (req.getRequestURI()) {

		case "/Project1/all.json":
			new ReimbursementDataController().sendAllData(res);
			break;

		case "/Project1/complete.json":
			new ReimbursementDataController().sendCompleteReimbursements(res);
			break;

		case "/Project1/pending.json":
			new ReimbursementDataController().sendCompletePendingReimbursements(res);
			break;

//		case "/Project1/pending.json":
//			new ReimbursementDataController().sendCompletePendingReimbursements(res);
//			break;

//		case "/HallowsMonsters/monster.json":
//			new SaveController().save(req, res);
//			break;
//		}
		}
	}
}
