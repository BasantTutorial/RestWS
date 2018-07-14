package com.bc.invoker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class BankClient {

	public double findInterest(String resourceType, String loanType) {
		final String RESOURSE_URI = "http://localhost:4040/SubResourceLocator/rest/transaction/";
		double interest = 0;
		ClientBuilder builder = ClientBuilder.newBuilder();
		Client client = builder.build();
		WebTarget target = client.target(RESOURSE_URI).path(resourceType)
				.queryParam("loanType", loanType);
		Response response = target.request().get();
		if (response.getStatus() == 200) {
			interest = response.readEntity(Double.class);
		}
		return interest;
		
	}

}
