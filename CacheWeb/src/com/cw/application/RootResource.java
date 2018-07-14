package com.cw.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.cw.resource.OrderResource;

@ApplicationPath("/rest")
public class RootResource extends ResourceConfig {

	public RootResource() {
		register(new OrderResource());
	}

}
