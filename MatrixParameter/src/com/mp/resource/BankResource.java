package com.mp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/bank")
public class BankResource {

	/*
	 * http://localhost:4040/MatrixParameter/rest/bank/findInterest/acc1;year=1993
	 * ?branchName=12&name=basanta
	 */

	@Path("/findInterest/{accountNo}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getInterest(@PathParam("accountNo") String accountNo,
			@QueryParam("branchName") int branchName,
			@QueryParam("name") String name, @MatrixParam("year") int year) {

		return "AccountNo: " + accountNo + ";" + "Year: " + year
				+ " BranchName: " + branchName + " Name: " + name;
	}

}
