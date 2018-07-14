package com.ari.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/all")
public class AllRsInjectionResource {
	@POST
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String printAllData(@QueryParam("name") String name,
			@PathParam("id") int id, @HeaderParam("dept") String dept,
			@FormParam("salary") double salary) {
		return "All Data For Rs Injection is :" + name + " : " + id + " : "
				+ dept + " : " + salary;
	}
}
