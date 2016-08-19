package com.n1k1ch.nstat.api.service;

import com.n1k1ch.nstat.db.entity.User;
import com.n1k1ch.nstat.db.service.UserService;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by ncherevkov on 7/5/2016.
 */
@Path("/users")
@RequestScoped
public class UsersService {

	@Inject
	private UserService userService;

	@GET
	@Produces({"application/json"})
	public Response getAll() {
		List<User> users = userService.findAll();

		return Response.ok(users).build();
	}


	@POST
	@Path("/register")
	@Produces("application/json")
	public Response register(User user) throws NoSuchAlgorithmException {
		User persistedUser = userService.create(user);

		return Response.created(URI.create("/users/" + persistedUser.getId())).build();
	}
}
