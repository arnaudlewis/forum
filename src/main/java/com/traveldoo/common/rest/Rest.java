package com.traveldoo.common.rest;

import com.traveldoo.user.service.LoginService;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class Rest extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public Rest() {
		singletons.add(new LoginService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
