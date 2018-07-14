package com.hp.cch.resource.writer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

@Provider
@Produces(MediaType.APPLICATION_XML)
public class TxXMLWritter implements MessageBodyWriter<Object> {
	@Override
	public long getSize(Object obj, Class<?> classType, Type rawType,
			Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isWriteable(Class<?> classType, Type rawType,
			Annotation[] annotations, MediaType mediaType) {
		if (classType.isAnnotationPresent(XmlRootElement.class)) {
			return true;
		}
		return false;
	}

	@Override
	public void writeTo(Object obj, Class<?> classType, Type rawType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> responseHeaders, OutputStream os)
			throws IOException, WebApplicationException {

		JAXBContext jaxbContext = null;
		Marshaller marshaller = null;

		try {
			jaxbContext = JAXBContext.newInstance(classType);
			marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(obj, os);
		} catch (JAXBException e) {
			throw new WebApplicationException("Marshalling Problem");
		}
	}
}
