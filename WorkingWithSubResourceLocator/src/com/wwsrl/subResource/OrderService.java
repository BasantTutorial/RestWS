package com.wwsrl.subResource;

import java.util.Date;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class OrderService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getProductInfo(@PathParam("productName") String productName) {
		return "ProductName: " + productName + " purchase on date: "
				+ new Date();

	}
}
