package com.bs.invoker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.bs.client.Bank;

public class BankResourceInvoker implements Bank {

	@Override
	public String getInterest(String accountNo, int branchName, String name,
			int year) {

		final String BANK_RESOURCE_URI = "http://localhost:4040/MatrixParameter/rest/bank/findInterest";

		String data = null;
		Client client = null;
		WebTarget target = null;
		ClientBuilder builder = null;

		builder = ClientBuilder.newBuilder();
		client = builder.build();
		target = client.target(BANK_RESOURCE_URI);

		target = target.path("/{accountNo}")
				.resolveTemplate("accountNo", accountNo)
				.matrixParam("year", year).queryParam("branchName", branchName)
				.queryParam("name", name);

		System.out.println(target.getUri().getPath());

		Response response = target.request().get();

		if (response.getStatus() == 200) {
			data = response.readEntity(String.class);
		}

		return data;
	}

}
