package com.n1k1ch.nstat.api.service;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ncherevkov on 7/5/2016.
 */
public class NStatApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public NStatApplication() {
		singletons.add(new UsersService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
