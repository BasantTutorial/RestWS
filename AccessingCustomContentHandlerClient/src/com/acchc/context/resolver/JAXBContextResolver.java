package com.acchc.context.resolver;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.acchc.dto.Profile;
import com.acchc.dto.RegisterInfo;

@Provider
public class JAXBContextResolver implements ContextResolver<JAXBContext> {
	JAXBContext jaxbContext;

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
