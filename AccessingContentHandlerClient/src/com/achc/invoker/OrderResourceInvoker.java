package com.achc.invoker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class OrderResourceInvoker {
	private Client client;

	private final String ROOT_ORDER_RESOURCE_URI = "http://localhost:4040/Multiple_Request_input_ContentHandler/rest/order";

	public String newOrder(String Order) {
		String msg = null;
		client = getClientInstance();
		Response response = client.target(ROOT_ORDER_RESOURCE_URI)
				.path("new/is").request().post(Entity.text(Order));

		if (response.getStatus() == 200) {
			msg = response.readEntity(String.class);
		}
		return msg;
	}

	private Client getClientInstance() {
		ClientBuilder builder = null;
		builder = ClientBuilder.newBuilder();
		builder = builder.property("connection.timeout", 1000);
		if (client == null) {
			client = builder.build();
		}
		return client;
	}

}
