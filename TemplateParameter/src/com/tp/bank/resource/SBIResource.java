package com.tp.bank.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*Instead Of send input value by using QueryParm we can use PathParam in GET Request
 * Which will be Easy for EndUser ,User No need to remember what is paramPath name
 * with full syntax like /rest/banking?accountNo=acc1 so he can easily send request like
 * http://localhost:4040/TemplateParameter/rest/banking/acc1
 * acc1 which we specified in path in resource class {accountNo}*/

@Path("/banking/{accountNo}")
public class SBIResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public double getBalance(@PathParam("accountNo") String accountNo) {
		double availableBalance = 0;

		switch (accountNo) {
		case "acc1":
			availableBalance = 1000;
			break;
		case "acc2":
			availableBalance = 2000;
			break;
		case "acc3":
			availableBalance = 3000;
			break;
		case "acc4":
			availableBalance = 4000;
			break;
		}
		return availableBalance;

	}

}
