package com.ow.application;

import org.glassfish.jersey.server.ResourceConfig;

import com.ow.resource.OxygenWalletResource;

public class OxygenWalletApplication extends ResourceConfig {

	public OxygenWalletApplication() {
		register(new OxygenWalletResource());
	}

}
