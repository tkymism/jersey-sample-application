package com.fujitsu.hope.labs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fujitsu.hope.labs.messages.Book;
import com.sun.jersey.api.NotFoundException;

@Path("/books")
public class BooksApi {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Book> getLibrary() {
		return LibraryResource.getInstance().asList();
	}
	
	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Book getBook(@PathParam("id") Integer id) {
		Book ret = LibraryResource.getInstance().asMap().get(id);
		if (ret == null) throw new NotFoundException("No such book.");
		else return ret;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response putBook(Book input) {
		LibraryResource.getInstance().asMap().put(input.getId(), input);
		return Response.ok().build();
	}

	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response deleteBook(Book input) {
		LibraryResource.getInstance().asMap().remove(input.getId());
		return Response.ok().build();
	}
}