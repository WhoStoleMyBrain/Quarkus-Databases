package org.agoncal.quarkus.panache.resources;

import java.util.List;

import org.agoncal.quarkus.panache.model.Book;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @GET
    @Path("/{id}")
    public Book findBookById(@PathParam("id") Long id) {
        return (Book) Book.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Book> listAllBooks() {
        return Book.listAll();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @POST
    public Response persistBook(Book book, @Context UriInfo uriInfo) {
        Book.persist(book);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(book.id));
        return Response.created(builder.build()).build();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @DELETE
    @Path("{id}")
    public void deleteBook(@PathParam("id") Long id) {
        Book.deleteById(id);
    }
}
