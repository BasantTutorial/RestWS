package comcch.provider.reader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

@Provider
@Produces(MediaType.APPLICATION_XML)
public class JAXBMessageBodyReader implements MessageBodyReader<Object> {

	@Override
	public boolean isReadable(Class<?> classType, Type rawType,
			Annotation[] annotations, MediaType mediaType) {
		if (classType.isAnnotationPresent(XmlRootElement.class)) {
			return true;
		}
		return false;
	}

	@Override
	public Object readFrom(Class<Object> classType, Type rawType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> requestHeaders, InputStream is)
			throws IOException, WebApplicationException {
		Object obj = null;
		JAXBContext jaxbContext = null;
		Unmarshaller unmarshaller = null;

		try {
			jaxbContext = JAXBContext.newInstance(classType);
			unmarshaller = jaxbContext.createUnmarshaller();
			obj = unmarshaller.unmarshal(is);
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new WebApplicationException(e);
		}

		return obj;
	}

}
