package com.fp.resource;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cab-management")
public class OlaCabManagementSystemResource {
	@Path("/book")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String book(@FormParam("source") String source,
			@FormParam("dest") String dest, @FormParam("cabType") String cabType) {
		return "Source: " + source + " Destination: " + dest + " CabType: "
				+ cabType + " Booked Successfully...";
	}

}
