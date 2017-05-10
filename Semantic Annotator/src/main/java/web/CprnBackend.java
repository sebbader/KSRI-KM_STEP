package main.java.web;

import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * "roter balken"
 * @author sba
 *
 */
public class CprnBackend {

	/**
	 * @author sba
	 * @return
	 */
	@GET
	public Response doGet() {
		return Response.ok().build();
	}


	@POST
	public Response postResource(@Context UriInfo uriinfo, @Context Request request) throws URISyntaxException {


		
		// Status: hier alle informationen über Java zugreifbar


		// JAX RS Client

		// client macht seinen Call

		// responses werden gelesen

		// als rdf über return zurückgegeben


		return Response.ok().build();
	}


}
