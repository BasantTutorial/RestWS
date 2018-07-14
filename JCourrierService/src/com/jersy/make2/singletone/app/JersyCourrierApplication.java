package com.jersy.make2.singletone.app;

import org.glassfish.jersey.server.ResourceConfig;

import com.jersy.courrier.service.CourrierResource;

public class JersyCourrierApplication extends ResourceConfig {

	public JersyCourrierApplication() {

		/* packages("com.jersy.courrier.service"); */

		/* register(CourrierResource.class); */

		/*
		 * Only this one is make my resource class as singleton above two are
		 * not working
		 * 
		 */
		register(new CourrierResource());
	}

}
