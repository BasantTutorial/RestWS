package com.srl.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

public class StateBankOfIndiaSubResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public double getInterestAmount(@QueryParam("loanType") String loanType) {
		double amount = 0;
		if (loanType.equalsIgnoreCase("CarLoan")) {
			return amount = 7;
		} else if (loanType.equalsIgnoreCase("HomeLoan")) {
			return amount = 9;
		} else if (loanType.equalsIgnoreCase("StudyLoan")) {
			return amount = 11;
		} else {
			return amount;
		}
	}

}
