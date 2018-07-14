package com.pathSegment.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.pathSegment.resource.MarriageResource;
@ApplicationPath("/rest")
public class RootResourceApplication extends ResourceConfig{

	public RootResourceApplication() {
		register(new MarriageResource());
	}

}
