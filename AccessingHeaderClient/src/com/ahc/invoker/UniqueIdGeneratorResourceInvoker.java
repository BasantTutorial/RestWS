package com.ahc.invoker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class UniqueIdGeneratorResourceInvoker {
	private Client client;

	private final String GENERATE_ID_BASE_RESOURCE_URI = "http://localhost:4040/HeaderParameter/rest/getId";

	public String getUniqueId(String id, String name) {
		String message = null;
		client = getClientInstance();
		Response response = client.target(GENERATE_ID_BASE_RESOURCE_URI)
				.path("/generate").path("/{name}")
				.resolveTemplate("name", name).request().header("id", id).get();

		if (response.getStatus() == 200) {
			message = response.readEntity(String.class);
		}

		return message;
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
