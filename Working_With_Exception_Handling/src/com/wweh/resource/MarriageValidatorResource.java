package com.wweh.resource;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.wweh.dto.Acknowledgement;
import com.wweh.dto.User;
import com.wweh.exception.InvalidAgeException;

@Path("/marriage")
public class MarriageValidatorResource {
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	// Approach 1 to handle Exception which is not preferable
	public Response addCandidate(User user) {
		if (user.getAge().equals("18")) {
			try {
				throw new InvalidAgeException("Age shouldn't be less than 18");
			} catch (InvalidAgeException e) {
				e.printStackTrace();
			}
		}

		Acknowledgement acknowledgement = new Acknowledgement();
		acknowledgement.setId(UUID.randomUUID().toString());
		acknowledgement.setStatus("Eligible");
		acknowledgement.setVisits(10);

		return Response.ok().header("Request", "Accepted")
				.entity(acknowledgement).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Path("/approach2")
	// Approach 2 to handle Exception which is more preferable
	/*==========================================================
	 * In this Approach We can Wrap our Exception Into JAX-RS provided Exception
	 * Which can be well formated because to add response body to that exception
	 * object what ever we want to mention about our exception we can add in
	 * response object as per below which reduces burden of developer
	 */
	public Response addCandidateApproach2(User user) {
		if (user.getAge().equals("18")) {
			try {
				throw new InvalidAgeException("Age shouldn't be less than 18");
			} catch (InvalidAgeException e) {
				throw new WebApplicationException(
						Response.serverError()
								.entity("<error><errorCode>0rt1234</errorCode><message>Age Mismatch</message></error>")
								.status(619).build());
			}
		}

		Acknowledgement acknowledgement = new Acknowledgement();
		acknowledgement.setId(UUID.randomUUID().toString());
		acknowledgement.setStatus("Eligible");
		acknowledgement.setVisits(10);

		return Response.ok().header("Request", "Accepted")
				.entity(acknowledgement).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Path("/approach3")
	// Approach 3 to handle Exception which is also more preferable
	/*================================================================
	 * In this approach we can directly throws our checked exception cause my
	 * exception handle by one of provider class which is exceptionMapper which
	 * helps to avoid boiler plate code logic from my resource class and
	 * ExceptionMapper class can called by JAX-RS Runtime so we no need to do
	 * anything..
	 * 
	 * Reason:-
	 * =======
	 * If My multiple resource class have throws same exception instead of
	 * writing it in each resource method we can write it in one ExceptionMapper 
	 * class which is takes care by runtime 
	 */
	public Response addCandidateApproach3(User user) throws InvalidAgeException {

		if (user.getAge().equals("18")) {
			throw new InvalidAgeException("Invalid age");
		}

		Acknowledgement acknowledgement = new Acknowledgement();
		acknowledgement.setId(UUID.randomUUID().toString());
		acknowledgement.setStatus("Eligible");
		acknowledgement.setVisits(10);

		return Response.ok().header("Request", "Accepted")
				.entity(acknowledgement).build();
	}
}
