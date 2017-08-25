package edu.kit.aifb.step.sensor.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;

import io.swagger.annotations.Api;

/**
 * Class handling RESTful requests on http://<host>:<port>/step/wrapper/sensor resource
 * @author sba
 *
 */
//@Path(value = "/sensor")
//@Api(value = "Sensor", description = "APIs the sensor")
//public class AdministrationShellWebAPI extends Application{
public class AdministrationShellWebAPI {

	WebAPIDescriptions description = new WebAPIDescriptions();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String doGet_plain() {
		return description.getHTML();
	}

	@GET 
	@Produces(MediaType.TEXT_HTML)
	public String doGet_html() {
		return description.getHTML();	
	}

	@GET 
	@Produces(MediaType.APPLICATION_XML)
	public String doGet_xml() {
		return description.getXMLData();
	}
	
	@GET 
	@Produces("text/turtle")
	public String doGet_turtle() {
		return description.getTurtle();
		
	}

	@GET 
	@Produces("application/ntriples")
	private String doGet_ntriples() {
		return description.getNtriples();
	}
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public String doGet_json() {
		return description.getJSON();		
	}
	
	@GET 
	@Produces("application/ld+json")
	private String doGet_jsonld() {
		return description.getJSONLD();
	}

	
	

}
