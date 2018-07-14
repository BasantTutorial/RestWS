package com.ap.application;

import org.glassfish.jersey.server.ResourceConfig;

import com.ap.resource.StockResource;

public class StockRootResource extends ResourceConfig {

	public StockRootResource() {
		register(new StockResource());
	}

}
