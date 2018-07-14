package com.apc.application;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

import com.apc.resource.BankTransactionResource;

@ApplicationPath("/rest")
public class RootResourceApplication extends ResourceConfig {

	public RootResourceApplication() {
		register(new BankTransactionResource());
	}

	

}
