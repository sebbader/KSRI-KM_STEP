package main.java.lucene.search;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.core.UriInfo;

import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.Resource;
import org.semanticweb.yars.nx.namespace.RDF;
import org.semanticweb.yars.nx.parser.NxParser;
import org.semanticweb.yars.parsers.external.json.jsonld_java.JsonLDserialiser;
import org.semanticweb.yars.parsers.external.json.jsonld_java.JsonLDserialiser.NxParser2JsonLDjava;


@Path("/autocomplete")
public class Autocompleter {

	@GET
	public Response doGet() {
		return Response.ok().build();
	}


	@POST
	public Response postResource(@Context UriInfo uriinfo, @Context Request request) throws URISyntaxException {

		OutputStream output = new OutputStream()
	    {
	        private StringBuilder string = new StringBuilder();
	        @Override
	        public void write(int b) throws IOException {
	            this.string.append((char) b );
	        }

	        //Netbeans IDE automatically overrides this toString()
	        public String toString(){
	            return this.string.toString();
	        }
	    };


		List<Node[]> list = new LinkedList<Node[]>();

		URI absPath = new URI("http://example.org/");
		URI base = absPath;

		Resource baseRes = new Resource(base.toString());

		list.add(new Node[] { baseRes, RDF.TYPE, RDF.BAG });
		list.add(new Node[] { baseRes, RDF.TYPE, new Resource("http://example.org/ex") });


		
//		JsonLDserialiser serializer = new JsonLDserialiser(output, base );
//
//		serializer.processStatement(list.get(0));
//		serializer.processStatement(list.get(1));
		


//		return Response.ok(new GenericEntity<Iterable<Node[]>>(list) {  }).build();
		return Response.ok(output.toString()).build();

	}
	
	

}
