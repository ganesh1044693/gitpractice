package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/json/customer")
public class JSONCustomerService {
	@GET
	@Path("/get")
	@Produces({MediaType.APPLICATION_JSON})	
	public Response getProductInJSON() {

		Customer product = new Customer();
		product.setName("Amaozon");
		product.setId("1000");		
		return Response.status(201).entity(product).build();

	}

}
