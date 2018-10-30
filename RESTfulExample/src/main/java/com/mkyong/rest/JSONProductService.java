package com.mkyong.rest;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

@Path("/json/product")
public class JSONProductService {
	
	
	

	@GET
	@Path("/get")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})	
	public Response getProductInJSON() throws JsonParseException, JsonMappingException, IOException {

		Product product = new Product();
		product.setName("iPad 3");
		product.setQty(999);
		RestClient restClient= new RestClient(); 
		String coustomer=restClient.getCustmer();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readValue(coustomer, JsonNode.class);
		String name= node.get("name").getValueAsText();
		product.setCustomer(name);
		return Response.status(201).entity(product).build();

	}

	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(Product product) {

		String result = "Product created : " + product;
		return Response.status(201).entity(result).build();
		
	}
	
}