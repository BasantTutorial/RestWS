package com.hp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/getId")
public class UniqIdGenerateorResource {

	/*
	 * Request:
	 * http://localhost:4040/HeaderParameter/rest/getId/generate/Basanta
	 * Response: Hi Basanta Your SystemGenerated ID is: GEN143BH
	 * 
	 * See as i pass only name in requestUri and id in header:
	 */

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/generate/{name}")
	public String getUniqueId(@HeaderParam("id") String id,
			@PathParam("name") String Name) {
		return "Hi " + Name + " Your SystemGenerated ID is: " + id;
	}
}
