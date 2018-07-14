package comcch.application;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;

import comcch.provider.reader.JAXBMessageBodyReader;
import comcch.provider.writter.JAXBMessageBodyWritter;

@ApplicationPath("/rest")
public class RootResource extends Application {

	/*public RootResource() {
		register(new JAXBMessageBodyReader());
		register(new JAXBMessageBodyWritter());
	}*/

}
