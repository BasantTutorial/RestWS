package com.acchc.invoker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.acchc.context.resolver.JAXBContextResolver;
import com.acchc.dto.Profile;
import com.acchc.dto.RegisterInfo;
import com.acchc.provider.reader.JAXBMessageBodyReader;
import com.acchc.provider.writter.JAXBMessageBodyWritter;

public class MatrimonyResourceInvoker {
	private Client client;
	private final String ROOT_RESOURCE_URI = "http://localhost:4040/CCH_Using_ContextResolver/rest/marriage";

	public Profile register(RegisterInfo registerInfo) {

		Profile profile = null;
		WebTarget target = null;
		client = getClientInstance();

		target = client.target(ROOT_RESOURCE_URI).path("register")
				.register(JAXBContextResolver.class)
				.register(JAXBMessageBodyReader.class)
				.register(JAXBMessageBodyWritter.class);

		Response response = target.request().accept(MediaType.APPLICATION_XML)
				.post(Entity.xml(registerInfo));
		if (response.getStatus() == 200) {
			profile = response.readEntity(Profile.class);
		}

		return profile;
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
