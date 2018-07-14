package com.bp.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.bp.resource.ExamInfo;

@ApplicationPath("/rest")
public class RootResourceApplication extends ResourceConfig {

	public RootResourceApplication() {
		register(new ExamInfo());
	}

}
