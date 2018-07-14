package com.dva.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/care")
public class CustomerCareResource {

	/*
	 * This @DefaultValue() is applicable for QueryParm Injection cause it is
	 * optional http://localhost:4040/DefaultValue_Annotation/rest/care/contact
	 * Here i m not passing any QueryParm so it will give me the value of
	 * emergency only coz i declare it as defaultValue
	 */

	@Path("/contact")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public long getTollFreeNumber(
			@DefaultValue("Emergency") @QueryParam("opName") String operatorName) {
		long contactNo = 0;
		switch (operatorName) {
		case "BSNL":
			contactNo = 1503;
			break;
		case "AIRTEL":
			contactNo = 123;
			break;
		case "AIRCEL":
			contactNo = 121;
			break;
		case "RELIANCE":
			contactNo = 367;
			break;

		case "Emergency":
			contactNo = 100;
			break;
		}

		return contactNo;
	}
}
