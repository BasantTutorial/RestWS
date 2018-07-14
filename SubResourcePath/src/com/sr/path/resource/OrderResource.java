package com.sr.path.resource;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/order")
public class OrderResource {

	/*
	 * Both the Resource Method have GET with same parameter so when i sent
	 * =========================================================================
	 * request with http://localhost:4040/SubResourcePath/rest/order?orderId=123
	 * =========================================================================
	 * Then it will causes ambiguity coz my servlet can't identify appropiate
	 * resource for this specific path uri so we need to tell by adding sub path*/
	 

	/* http://localhost:4040/SubResourcePath/rest/order/track?orderId=123 */
	@Path("/track")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String trackOrder(@QueryParam("orderId") int orderId) {
		return "OrderId: " + orderId
				+ " is in New-Delhi & it will be dispatche soon";
	}

	/* http://localhost:4040/SubResourcePath/rest/order/getOrderAvailability?orderId=123 */
	@Path("/getOrderAvailability")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getOrderAvailability(@QueryParam("orderId") int orderId) {
		return "Your Order No " + orderId + " will be reach at most probably: "
				+ new Date().toString();
	}

}
