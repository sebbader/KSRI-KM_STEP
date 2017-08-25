package FLS_Wrapper_Demo;

import java.rmi.RemoteException;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import de.tourenserver.www.CallInfoRec;
import demo.ConnectFLS;

@Path("/visitour/tour{VTID}")
public class FLS_GPS_Wrapper_Resource {

	String exID = "";

	@GET
	@Produces("text/turtle")
	public Response executeQueryOnSOAP(@PathParam("VTID") String VTID) {
		ConnectFLS connector = new ConnectFLS();
		try {
			
			CallInfoRec tour = connector.showCallInfo(Integer.parseInt(VTID), "");
			
			HashMap<String, Float> gps = connector.getGPSofCustomer(Integer.parseInt(VTID), "");
			float latitude = gps.get("gps_latitude");
			float longitude = gps.get("gps_longitude");

			String RDF = "<>  <http://example.org/hasID> \"" + tour.getExtID() + "\" ; "
					+ "<http://example.org/hasCity> \"" + tour.getCity() + "\" ; "
					+ "<http://example.org/hasCustomer> [ "
					+ "<http://gm/#lat>  " + latitude + " ; "
					+ "<http://gm/#lng>  " + longitude + " "
					+ "]"
					+ "  .";

			return Response.status(Response.Status.ACCEPTED).entity(RDF).build();
		} catch (RemoteException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("<> <http://example.org/returns> <http://example.org/Error>").build();
		} catch (NullPointerException e) {
			e.printStackTrace();
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}

