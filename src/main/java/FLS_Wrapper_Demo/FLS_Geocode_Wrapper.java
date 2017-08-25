package FLS_Wrapper_Demo;

import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.rpc.holders.IntHolder;
import javax.xml.rpc.holders.StringHolder;

import org.semanticweb.yars.nx.Literal;
import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.Resource;
import org.semanticweb.yars.nx.namespace.RDF;
import org.semanticweb.yars.nx.namespace.RDFS;

import de.tourenserver.www.VisiTourSoap;
import de.tourenserver.www.VisiTourSoapProxy;
import de.tourenserver.www.holders.ArrayOfAppointmentHolder;
import demo.ConnectFLS;


/**
 * <http://localhost:9080/stepwrapper/fls/visitour/tour33>
 * @author sba
 *
 */
@Path("/visitour")
public class FLS_Geocode_Wrapper {

	@Context UriInfo uri;

	static HashMap<String, Iterable<Node[]>> calls = new HashMap<String, Iterable<Node[]>>();
	static int counter = 0;



	/**
	 * 
	 * returns basic descriptions on the wrapper root resource
	 * 
	 * @param collection
	 * @param uriinfo
	 * @return
	 */
	@GET
	public Response doGet(@Context UriInfo uriinfo) {

		List<Node[]> graph = new ArrayList<Node[]>();

		//		String rdf = "<> <http://example.org/is> \"geo gps coding webservice\" ; "
		//				+ " a <http://example.org/webservice> . ";
		Node base = new Resource("#this");
		graph.add( new Node[] {base, new Resource("http://example.org/is/"), new Literal("the fls visitour REST web service")} );
		graph.add( new Node[] {base, RDF.TYPE, new Resource("http://www.fastleansmart.com/en/products/fls-visitour/")} );

		return Response.status(Response.Status.OK).entity(new GenericEntity<Iterable<Node[]>>( graph ) { }).build();
	}


	/**
	 * creates a new call
	 * 
	 * @param collection
	 * @param uriinfo
	 * @param input
	 * @return
	 * @throws URISyntaxException
	 */
	@POST
	public Response doPost(@Context UriInfo uriinfo, Iterable<Node[]> input) throws URISyntaxException {

		String new_resource  = String.valueOf(++counter);
		for (Node[] node : input) {
			if (node[1].getLabel().toLowerCase().contains("hasextid") && node[2] instanceof Literal) {
				String new_resource_string = node[2].getLabel(); 
				if (!calls.containsKey(new_resource_string)) {
					new_resource = new_resource_string;
					break;
				} else {
					throw new IllegalArgumentException("ExtID is already used! Cannot create already exisiting resource.");
				}
			}
		}

		calls.put(new_resource, input);

		// input parameters
		VisiTourSoap visitour = new VisiTourSoapProxy();
		String country = null;
		String ZIP = null;
		String city = null;
		String district = null;
		String street = null;
		String HNr = null;
		Integer x = null;
		Integer y = null;
		String areaOfExpertiseID = null;
		Integer servicetype = 1; //0 = default = service, 1 = maintenance, 2 = guarantee, 3 = full service, 4 = delivery, 5 = pickup, 6 = consulting, 10 - 89 = individual values, 90 = office job (if Module is activated)
		Integer priority = null;
		String skills = null;
		Calendar dateFrom = null;
		Calendar dateTo = null;
		Calendar timeFrom = null;
		Calendar timeTo = null;
		Integer duration = null;
		Calendar dateTime = null;
		
		//output parameters
		ArrayOfAppointmentHolder appointments = null;
		StringHolder infoText = null;
		
		try {
			visitour.call(0, new Integer(0), "", new_resource, new IntHolder(0),
				"", "", "", "", "",
				"", "", "", "", "",
				"", "", country, ZIP, city, 
				district, street, HNr, x, y,
				"", areaOfExpertiseID, "", "", servicetype,
				priority, "", "", "", "", 
				"", new Integer(0), skills, new Integer(0), dateFrom, 
				dateTo, timeFrom, timeTo, "", "", 
				"", duration, new Integer(0), new Integer(0), new Integer(0),
				new Integer(0),new Integer(0), new Float(0), dateTime, new Integer(2),
				new Integer(0), new Integer(0), "", "", "", 
				"", new Integer(0), new Integer(0), new Integer(0), new IntHolder(0), 
				infoText, appointments);
		} catch (RemoteException e) {
			
			Response.serverError().build();
		}

		return Response.created(new URI(uriinfo.getAbsolutePath() + new_resource) ).build();

	}



	/**
	 * creates a new call
	 * 
	 * @param collection
	 * @param uriinfo
	 * @param input
	 * @return
	 * @throws URISyntaxException
	 */
	@POST
	public Response doPost(@Context UriInfo uriinfo, String input) throws URISyntaxException {

		URI new_resource  = new URI(uriinfo.getAbsolutePath().toString() + ++counter);
		List<Node[]> graph = new ArrayList<Node[]>();
		graph.add(new Node[] {new Resource(new_resource.toString()), RDFS.COMMENT, new Literal(input)  } );
		calls.put(new_resource.toString(), graph);

		// TODO: weiter ausführen

		return Response.status(406).build();

	}



	@PUT
	public Response doPut() {		
		// Method not allowed
		return Response.status(405).build();
	}


	@DELETE
	public Response doDelete() {
		// Method not allowed
		return Response.status(405).build();
	}



	@OPTIONS
	public Response doOptions(@Context UriInfo uriinfo) {
		return doGet(uriinfo);
	}


	@HEAD
	public Response doHead(@Context UriInfo uriinfo) {
		return doGet(uriinfo);
	}


	

	//========================================================
	//
	// 						CALLS
	//
	//========================================================
	
	@Path("/{ExtID}")
	@GET
	public Response fireQuery(@PathParam("ExtID") String number) {

		if (calls.containsKey(Integer.parseInt(number))) {

			String RDF = "<> <http://example.org/is> \"" + number + "\" ; "
					+ " a <http://example.org/query> . ";

			return Response.ok().entity(RDF).build();
		} else {
			return Response.status(410).build();
		}
	}
	
	
	
}

