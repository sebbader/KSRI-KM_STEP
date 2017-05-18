package main.java.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.semanticweb.yars.nx.BNode;
import org.semanticweb.yars.nx.Literal;
import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.Resource;
import org.semanticweb.yars.nx.dt.string.XsdString;
import org.semanticweb.yars.nx.namespace.RDF;
import org.semanticweb.yars.nx.namespace.RDFS;

import main.java.lucene.search.LuceneSearcher;
import main.java.namespaces.STEP;


@Path("/autocomplete")
public class Autocompleter {
	

	@Context
	ServletContext _ctx;
	
	
	public final String baseURI = "http://people.aifb.kit.edu/mu2771/step";

	public final String indexLocation = "/resources/StepOntologyIndex/lucene";

	/**
	 * @author sba
	 * @return information on the service
	 */
	@GET
	public Response doGet() {
		return Response
				.ok("This service returns suggestions for query terms by searching the STEP ontology: "
						+ "http://people.aifb.kit.edu/mu2771/step/"
						+ "\n\n"
						+ "In order to use the service, send a POST request with RDF triples containing at least one "
						+ "[] " + STEP.hasInformation + " ?query_literal . "
								+ "\n"
								+ "The response graph includes a sorted list with "
								+ " [] " + STEP.hasInformation + " <autocomplete_suggestion_literal> . ")
				.build();
	}


	/**
	 * 
	 * @param collection
	 * @param uriinfo
	 * @param input
	 * @return
	 */
	@POST
	//@RedirectMissingTrailingSlash
	public Response postResource(@PathParam("collection") String collection, @Context UriInfo uriinfo,
			Iterable<Node[]> input) {
		

		List<Node[]> list = new ArrayList<Node[]>();
		list.add(new Node[] { new BNode(""), RDF.TYPE, new Resource(STEP.NS + "Autocompletion" ) });

		
		
		String query = getQueryTerm(input);
		if (query == null || query.isEmpty()) {
			list.add(new Node[] { new BNode(""), RDFS.LABEL, new Literal( "Autocompletion failed: query is empty. "
					+ "Please insert one triple with " + STEP.hasInformation.toString() + " predicate and query as literal.", XsdString.DT ) } );
			return Response.ok().entity(
					new GenericEntity<Iterable<Node[]>>( list )  { } ).build();
		}

		
		LuceneSearcher searcher = new LuceneSearcher(_ctx.getRealPath("") + indexLocation);
		try {
			list.addAll( searcher.search(query) );
		} catch (IOException e) {
			// add nothing, only empty results
			e.printStackTrace();
			list.add(new Node[] { new BNode(""), RDFS.LABEL, new Literal( "Autocompletion failed: " + e.toString() ) } );
			return Response.ok().entity(
					new GenericEntity<Iterable<Node[]>>( list )  { } ).build();
		}
		
		
		

		return Response.ok(new GenericEntity<Iterable<Node[]>>( list ) { }).build();

	}

	

	private String getQueryTerm(Iterable<Node[]> input) {
		
		for ( Iterator<Node[]> iter = input.iterator(); iter.hasNext(); ) {
			Node[] node = iter.next();
			
			if (node[1].toString().equalsIgnoreCase( STEP.hasInformation.toString() ) ) {
				return ((Literal) node[2]).getLabel();
			}
		}
		
		return null;
	}
	
	
	

}
