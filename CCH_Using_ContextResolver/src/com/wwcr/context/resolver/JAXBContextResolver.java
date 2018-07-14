package com.wwcr.context.resolver;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.wwcr.dto.Profile;
import com.wwcr.dto.RegisterInfo;

@Provider
public class JAXBContextResolver implements ContextResolver<JAXBContext> {

	private JAXBContext jaxbContext;

	public JAXBContextResolver() throws JAXBException {
		jaxbContext = JAXBContext
				.newInstance(RegisterInfo.class, Profile.class);
	}

	@Override
	public JAXBContext getContext(Class<?> classType) {

		if (classType.isAssignableFrom(RegisterInfo.class)
				|| classType.isAssignableFrom(Profile.class)) {
			return jaxbContext;
		}

		return null;
	}

}
