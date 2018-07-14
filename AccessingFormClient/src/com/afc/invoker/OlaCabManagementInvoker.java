package com.afc.invoker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

public class OlaCabManagementInvoker {

	private Client client;

	private final String CAB_MANAGEMENT_ROOT_RESOURCE_URI = "http://localhost:4040/FormParameter/rest/cab-management";

	public String bookCab(String source, String dest, String cabType) {

		client = getClientInstance();
		String confirmMsg = null;
		
		Form form = new Form();
		form.param("source", source);
		form.param("dest", dest);
		form.param("cabType", cabType);

		Response response = client.target(CAB_MANAGEMENT_ROOT_RESOURCE_URI)
				.path("/book").request().post(Entity.form(form));

		if (response.getStatus() == 200) {
			confirmMsg = response.readEntity(String.class);
		}

		return confirmMsg;
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
