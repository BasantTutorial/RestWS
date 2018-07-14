package com.ap.invoker;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class StockResourceInvoker {
	private Client client;
	final String ROOT_RESOURCE_URI = "http://localhost:4040/AsynchWeb/rest/stock";

	public void getPrice(String stockName) throws InterruptedException,
			ExecutionException {
		client = getClientInstance();
		WebTarget target = null;
		Response response = null;
		double value = 0;
		target = client.target(ROOT_RESOURCE_URI).path("/price")
				.path("{stockName}").resolveTemplate("stockName", stockName);
		Future<Response> future = target.request().async().get();
		response = future.get();
		if (response.getStatus() == 200) {
			value = response.readEntity(Double.class);
			System.out.println(value);
		}

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
