package com.jersy.make1.singletone.app;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.jersy.courrier.service.CourrierResource;

public class JersyCourierApplication extends Application {

	private Set<Class<?>> classes;
	private Set<Object> singletones;

	public JersyCourierApplication() {
		classes = Collections.emptySet();
		singletones = new HashSet<Object>();
		singletones.add(new CourrierResource());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletones;
	}

}
