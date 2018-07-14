package com.wweh.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.wweh.exception.InvalidAgeException;

@Provider
public class CustomExceptionMapper implements
		ExceptionMapper<InvalidAgeException> {

	@Override
	public Response toResponse(InvalidAgeException arg0) {
		return Response
				.serverError()
				.entity("<error><errorCode>0rt1234</errorCode><message>Age Mismatch</message></error>")
				.status(619).build();
	}

}
