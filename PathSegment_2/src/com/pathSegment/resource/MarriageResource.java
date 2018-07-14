package com.pathSegment.resource;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

@Path("/mrg")
public class MarriageResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/status/{name}/{religion}")
	public String getMarriageStatus(@PathParam("name") PathSegment nameSegment,
			@PathParam("religion") PathSegment religionSegment,
			@MatrixParam("age") int age) {

		// PathSegment is used for to get all matrixParameter from URI path by
		// programmatic approach

		StringBuffer sb = null;
		MultivaluedMap<String, String> matrixParmMap = null;
		sb = new StringBuffer();
		// This for NameSegment
		sb.append("NAME: ").append(nameSegment.getPath())
				.append("MatrixParameters: ");

		matrixParmMap = nameSegment.getMatrixParameters();
		Set<?> nameSegmentCollection = matrixParmMap.entrySet();

		Iterator<?> itr1 = nameSegmentCollection.iterator();

		iteratorMethod(itr1, sb);

		// This For ReligionSegment:

		sb.append("RELIGION: ").append(religionSegment.getPath())
				.append("Matrix Parameters: ");

		matrixParmMap = religionSegment.getMatrixParameters();

		Set<?> religionSegmentCollection = matrixParmMap.entrySet();

		Iterator<?> itr2 = religionSegmentCollection.iterator();
		iteratorMethod(itr2, sb);

		return sb.toString();
	}

	private void iteratorMethod(Iterator<?> itr, StringBuffer sb) {
		while (itr.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<String, String> get = (Map.Entry<String, String>) itr
					.next();
			sb.append(get.getKey()).append("," + get.getValue());
		}
	}
}

/*
 * return "NAME: -" + candidateName + " MP-AGE: " + age + " RELIGION: -" +
 * religion + " AGE: " + age;
 */