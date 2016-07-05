package com.n1k1ch.nstat.api.security;

import org.apache.log4j.Logger;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by ncherevkov on 7/5/2016.
 */
@Provider
@ServerInterceptor
public class SecurityInterceptor implements ContainerRequestFilter {

	private static final Logger logger = Logger.getLogger(SecurityInterceptor.class);

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		logger.info("filter at " + requestContext.getDate());

		//TODO: see SecurityInterceptorExample
	}
}
