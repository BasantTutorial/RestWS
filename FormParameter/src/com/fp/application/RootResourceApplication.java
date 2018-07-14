package com.fp.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.fp.resource.OlaCabManagementSystemResource;

@ApplicationPath("/rest")
public class RootResourceApplication extends ResourceConfig {

	public RootResourceApplication() {
		register(new OlaCabManagementSystemResource());
	}

}
