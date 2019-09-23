package com.airhacks.api;

import com.airhacks.models.Book;
import com.airhacks.repository.BookRepository;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("books")
public class BookEndpoint {

    @Inject
    private BookRepository bookRepository;

    @GET
    @Path("/isAlive")
    public Response isAlive(){
        return Response.ok("im Alive").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getBooks")
    public Response getBooks(){
        List<Book> allBooks = bookRepository.findAllBooks();
        return Response.ok(allBooks).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id : \\d+}")
    public Response findBook(@PathParam("id") int id) {
        Book book = bookRepository.findBook(id);
        return Response.ok(book).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createBook")
    public Response createBook(Book book, @Context UriInfo uriInfo) {
        Book createdBook = bookRepository.createBook(book);
        //FIXME Return the correct base uri
        URI createdURI = uriInfo.getRequestUriBuilder().path(String.valueOf(createdBook.getId())).build();
        return Response.created(createdURI).build();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countAllBooks() {
        Long count = bookRepository.countAllBooks();
        return Response.ok(count).build();
    }

    //TODO - Create a api PUT endpoint to update the book
}
