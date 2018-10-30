package com.jersey.series.spring.hibernate.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jersey.series.spring.hibernate.dao.BookDAOImpl;
import com.jersey.series.spring.hibernate.model.Book;

@Component
@Path("/bookservice")
public class BookServiceImpl {

	@Autowired
	private BookDAOImpl bookDAO;

	// http://localhost:8080/Jersey-Spring-Hibernate/rest/bookservice/getbook/1
	@GET
	@Path("getbooks")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getBookInfo() {

		List<Book> getBook = bookDAO.getBookInfo();
		return Response.status(Status.OK).entity(getBook).build();
	}

}