package com.ap.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/stock")
public class StockResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/price/{stockName}")
	public void getStockPrice(@PathParam("stockName") String stockName,
			@Suspended final AsyncResponse asyncResponse) {

		new Thread() {
			@Override
			public void run() {
				asyncResponse.resume(Response.ok().entity(20000).build());
			}
		}.start();
	}

}
