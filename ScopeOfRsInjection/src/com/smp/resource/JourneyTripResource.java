package com.smp.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/journey/{journeyType}/{source}/{dest}")
public class JourneyTripResource {

	/*
	 * The Scope of any type of injection whether it QuerryParm or PathParam or
	 * MatrixParm it always read the parameter value which is passes at method
	 * level not at class level
	 * 
	 * Request:-http://localhost:4040/ScopeOfRsInjection/rest/journey
	 * /family/banglore/goa/getInfo/longtoure
	 * 
	 * Responce: Source: banglore Destination: goa JourneyType: longtoure
	 * 
	 * See here journeyType value is consider from method level longtoure
	 * but not from class level which is goa...
	 */

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getInfo/{journeyType}")
	public String getJourneyInfo(@PathParam("source") String source,
			@PathParam("dest") String destination,
			@PathParam("journeyType") String journeyType) {
		return "Source: " + source + " Destination: " + destination
				+ " JourneyType: " + journeyType;
	}

}
