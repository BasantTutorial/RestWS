package com.wwhp.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

@Path("/book-show")
public class BookMyShowResource {
	@Path("/ticket")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String bookTicket(@Context HttpHeaders headers) {

		MultivaluedMap<String, String> headerMap = null;
		StringBuffer sb = null;
		sb = new StringBuffer();
		// By using this we can access all headers pass as request,We can access
		// Cookies also
		headerMap = headers.getRequestHeaders();

		for (String paramName : headerMap.keySet()) {
			sb.append("HeaderName: -").append(paramName);
			List<String> values = headerMap.get(paramName);
			for (String value : values) {
				sb.append("\nHeaderValue: -").append(value);
			}
		}

		return sb.toString();
	}
}
