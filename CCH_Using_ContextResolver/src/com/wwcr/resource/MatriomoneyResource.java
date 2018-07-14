package com.wwcr.resource;

import java.util.Random;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wwcr.dto.Profile;
import com.wwcr.dto.RegisterInfo;

@Path("/marriage")
public class MatriomoneyResource {
	@Path("/register")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Profile register(RegisterInfo register) {

		Profile profile = new Profile();
		profile.setId(UUID.randomUUID().toString());
		profile.setName(register.getName());
		profile.setMemberType("Premimum");
		profile.setVisits(new Random(2).nextInt());
		return profile;
	}

}
