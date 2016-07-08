package com.n1k1ch.nstat.api.service;

import com.n1k1ch.nstat.db.entity.Entry;
import com.n1k1ch.nstat.db.service.EntryDbService;

import javax.annotation.security.DenyAll;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Optional;

/**
 * Created by ncherevkov on 7/5/2016.
 */
@Path("/entries")
@RequestScoped
public class EntriesService {

	@Inject
	private EntryDbService entryDbService;

	@GET
	@Produces("application/json")
	public Response getAll() {
		return Response.ok(entryDbService.findAll()).build();
		//return Response.ok("Hola!").build();
	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response create(Entry entry) {
		if (entry == null) {
			return Response.status(400).build();
		}

		Long createdId = entryDbService.saveEntry(entry);
		return Response.created(URI.create("entries/" + createdId)).build();
	}

	@PUT
	@Path("/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(@PathParam("id") Long id, Entry entry) {
		if (id == null || entry == null) {
			return Response.status(400).build();
		}

		Optional<Entry> result = entryDbService.updateEntry(id, entry);

		if (!result.isPresent()) {
			return Response.status(404).build();
		}

		return Response.status(200).entity(result.get()).build();
	}

	@DenyAll
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public Response delete(@PathParam("id") Long id) {
		boolean delete = entryDbService.delete(id);

		if (!delete) {
			return Response.status(404).build();
		} else {
			return Response.noContent().build();
		}
	}
}
