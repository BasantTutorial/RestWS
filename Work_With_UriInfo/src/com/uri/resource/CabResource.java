package com.uri.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

@Path("/cab")
public class CabResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{source}/{destination}")
	public String bookNow(@Context UriInfo uriInfo) {
		StringBuffer sb = null;
		MultivaluedMap<String, String> queryMap = null;
		sb = new StringBuffer();

		// This One is to get All PathParameter Value From URI
		queryMap = uriInfo.getPathParameters();
		String pathParmInfo = getUriQuery(sb, queryMap);

		// This One is to get All QueryParameter Value From URI
		queryMap = uriInfo.getQueryParameters();
		String queryParamInfo = getUriQuery(sb, queryMap);

		String bothParm = pathParmInfo + queryParamInfo;

		return bothParm.toString();
	}

	private String getUriQuery(StringBuffer sb,
			MultivaluedMap<String, String> queryMap) {
		for (String paramName : queryMap.keySet()) {
			sb.append("ParamName: " + paramName);
			List<String> value = queryMap.get(paramName);
			for (String values : value) {
				sb.append("=").append(values);
			}
		}
		return sb.toString();
	}
}
