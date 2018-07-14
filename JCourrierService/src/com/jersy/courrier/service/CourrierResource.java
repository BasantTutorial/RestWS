package com.jersy.courrier.service;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/courrier")
public class CourrierResource {

	@GET
	@Produces("text/plain")
	public String getTrackingStatus(@QueryParam("agentId") String agentId,
			@QueryParam("trackingNo") int trackingNo) {

		return "Tracking No: " + trackingNo + " has been Dispatched On Date"
				+ new Date() + "With OrderId: " + this.hashCode();
	}

}
