package com.jcc.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class CourierClient {

	public static void main(String[] args) {
		ClientBuilder builder = null;
		Client client = null;
		WebTarget target = null;

		builder = ClientBuilder.newBuilder();
		builder.property("connection.timeout", 1000);
		client = builder.build();
		target = client
				.target("http://localhost:4040/JCourrierService/rest/courrier");
		target = target.queryParam("agentId", "dtdcAgent");
		target = target.queryParam("trackingNo", 143);

		Response response = target.request().get();

		if (response.getStatus() == 200) {
			String data = response.readEntity(String.class);
			System.out.println(data);
		}

	}

}
