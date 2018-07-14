package com.hp.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.hp.resource.UniqIdGenerateorResource;



@ApplicationPath("/rest")
public class RootResourceApplication extends ResourceConfig {

	public RootResourceApplication() {
		register(new UniqIdGenerateorResource());
	}

}
