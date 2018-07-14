package com.cp.resource;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/courier")
public class DTDCCourierResource {
	@Path("/track/{trackNo}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String trackOrder(@CookieParam("agentId") String agentId,
			@PathParam("trackNo") String trackNo) {
		return "AGENT-ID: " + agentId + " TRACKING-NO: " + trackNo;
	}

	public Response createCookie(@CookieParam("agentId") String agentId) {
		agentId="MYKING123";
		return Response.ok(agentId).build();
	}

}
