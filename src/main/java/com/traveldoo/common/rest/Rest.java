package com.traveldoo.common.rest;

import com.traveldoo.message.service.MessageService;
import com.traveldoo.subject.service.SubjectService;
import com.traveldoo.user.service.LoginService;
import com.traveldoo.user.service.UserService;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class Rest extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public Rest() {
		singletons.add(new LoginService());
        singletons.add(new UserService());
        singletons.add(new SubjectService());
        singletons.add(new MessageService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
