package com.wwsr.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.wwsr.dto.Ticket;
import com.wwsr.dto.User;

@Path("/railway")
public class RailwayReservationResource {

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response bookTicket(User user) throws URISyntaxException {

		Ticket ticket = new Ticket();
		ticket.setTicketNo(UUID.randomUUID().toString());
		ticket.setPersonName(user.getName());
		ticket.setBearthNo("Upper");
		ticket.setSource("Hydrabad");
		ticket.setDestination("Banglore");

		ResponseBuilder builder = null;
		Response response = null;
		builder = Response.created(new URI("/rest/railway"
				+ ticket.getTicketNo()));
		builder = builder.header("ECO", "RailwayService");
		builder = builder.entity(ticket);
		response = builder.build();
		return response;
	}
}
