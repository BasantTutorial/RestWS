package com.hp.cch.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hp.cch.dto.Status;
import com.hp.cch.dto.TransactionInfo;

@Path("/bank")
public class BankResource {
	@Path("/transaction")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response transaction(TransactionInfo transactionInfo) {
		Status status = new Status();
		status.setTxMode(transactionInfo.getTransactionType());
		status.setTxAmount(transactionInfo.getAmount());
		status.setTxLoc("BANGALORE");
		return Response.ok().status(800).entity(status).build();
	}

	@Path("/RWApproach")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Status getTxInfo(TransactionInfo transactionInfo) {
		Status status = new Status();
		status.setTxMode(transactionInfo.getTransactionType());
		status.setTxAmount(transactionInfo.getAmount());
		status.setTxLoc("HYDRABAD");
		return status;

	}
}
