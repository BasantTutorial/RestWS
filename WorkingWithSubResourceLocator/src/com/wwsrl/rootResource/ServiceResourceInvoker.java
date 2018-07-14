package com.wwsrl.rootResource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.wwsrl.subResource.ItemService;
import com.wwsrl.subResource.OrderService;

@Path("/serviceResource")
public class ServiceResourceInvoker {
	@Path("/instance/{serviceClassName}/{productName}")
	public Object getInstance(
			@PathParam("serviceClassName") String serviceClassName) {
		if (serviceClassName.equals("Item")) {
			return new ItemService();
		} else if (serviceClassName.equals("Order")) {
			return new OrderService();
		} else {
			return null;
		}
	}

}
