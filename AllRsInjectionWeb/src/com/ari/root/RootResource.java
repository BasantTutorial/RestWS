package com.ari.root;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.ari.resource.AllRsInjectionResource;

@ApplicationPath("/rest")
public class RootResource extends ResourceConfig {

	public RootResource() {
		register(AllRsInjectionResource.class);
	}

}
