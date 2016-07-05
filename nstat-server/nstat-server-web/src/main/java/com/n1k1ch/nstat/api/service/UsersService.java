package com.n1k1ch.nstat.api.service;

import com.n1k1ch.nstat.db.entity.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ncherevkov on 7/5/2016.
 */
@Path("/users")
public class UsersService {

	@GET
	@Produces({"application/json"})
	public Response getAll() {
		List<User> users = new ArrayList<>();

		User u1 = new User();
		u1.setName("Vasya");
		users.add(u1);

		User u2 = new User();
		u2.setName("Fedya");
		users.add(u2);

		return Response.ok(users).build();
	}
}
