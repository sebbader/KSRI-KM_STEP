package edu.kit.aifb.step.sensor.connector;

import org.apache.jena.rdf.model.Statement;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.graph.Triple;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.marmotta.ldclient.api.endpoint.Endpoint;
import org.apache.marmotta.ldclient.endpoint.rdf.LinkedDataEndpoint;
import org.apache.marmotta.ldclient.model.ClientConfiguration;
import org.apache.marmotta.ldclient.model.ClientResponse;
import org.apache.marmotta.ldclient.services.ldclient.LDClient;
import org.openrdf.query.BooleanQuery;
import org.openrdf.query.QueryLanguage;
import org.openrdf.repository.RepositoryConnection;

import edu.kit.aifb.step.Config;
import edu.kit.aifb.step.LdpResponse;
import edu.kit.aifb.step.StepLogger;
import edu.kit.aifb.step.sensor.AdministrationShell.AdministrationShell;

import org.openrdf.rio.RDFFormat;

public class LinkedDataPlatformConnector implements DatabaseConnector {


	//String url = "http://km.aifb.kit.edu/projects/step:8080/marmotta/ldp";
	//String container = "http://scc-cnor-129py5.scc.kit.edu:8080/marmotta/ldp/";
	private String containerURL;
	private String namespace;
	private String user;
	private String pwd;

	public LinkedDataPlatformConnector(Config config) {
		this.containerURL = config.getLDPContainer();
		this.namespace = config.getNamespace();
		this.user = config.getUser();
		this.pwd = config.getPwd();
	}

	@Override
	public void sendTriple(String subject, String predicate, String object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendQuadruple(Triple triple, String graphname) {

		StepLogger.getLogger().debug("\nAttempt sending " + graphname + ": " + triple.getSubject() + " " + triple.getPredicate() + " " + triple.getObject());
		//StepLogger.getLogger().debug("to CumulusRDF: " + " " + host + ":" + port + " "  + " " );



		StepLogger.getLogger().debug("Sent Tripel: " + triple.toString() + "\n");

	}


	// version using LDClient
	//	@Override
	//	public void sendTriples(List<Triple> triples) {
	//
	//		try {
	//
	//			ClientConfiguration clientConfig = new ClientConfiguration();
	//			Endpoint endpoint = new LinkedDataEndpoint();
	//			endpoint.setEndpointUrl(containerURL);
	//			clientConfig.addEndpoint(endpoint);
	//
	//
	//			//String DBPEDIA = "http://dbpedia.org/resource/Berlin";
	//			LDClient ldclient = new LDClient(clientConfig);
	//
	//			Boolean accessable = ldclient.ping("http://scc-cnor-129py5.scc.kit.edu:8080/marmotta/ldp");
	//
	//			System.out.println(accessable);
	//
	//		} catch (Exception e) {
	//			StepLogger.getLogger().error(e);
	//		}
	//
	//	}
	

	@Override
	public void sendTriples(Model model) {
		createResourceOrUpdate(model);
	}


	private void createResourceOrUpdate(Model model) {
		try {
			Map<String,Model> resources = new HashMap<String, Model>();

			StmtIterator iter = model.listStatements();
			while (iter.hasNext() ) {
				Statement stmt = iter.next();
				String subj = stmt.getSubject().getURI();
				if (resources.containsKey(subj)) {
					resources.get(subj).add( stmt );
				} else {
					resources.put(subj, ModelFactory.createDefaultModel().add(stmt) );
				}
			}

			for (Model new_data : resources.values()) {

				LdpResponse response = sendGET(new_data.listStatements().next().getSubject().getURI());
				if (response.getModel().isEmpty()) {
					sendPOST(containerURL, new_data);
				} else if (!isIncluded(new_data, response.getModel())) {
					new_data.add(response.getModel());
					sendPUT(response, new_data);
					//sendPut(container, body, proposedRessourceName, old_triples);
				}
			}

		} catch (Exception e) {
			StepLogger.getLogger().error(e);
		}
		
	}

	@Override
	public void sendTriples(List<Triple> triples) {

		//		String body = tripleSetToString(triples);
		//		String proposedRessourceSuffix = triples.get(0).getSubject().getURI().replace(containerURL, "");

		try {

			createResourceOrUpdate(triples);

			//sendPost(container, body, proposedRessourceSuffix);
			sendGET(triples.get(0).getSubject().getURI());

		} catch (Exception e) {
			StepLogger.getLogger().error(e);
		}

	}

	/**
	 * Send triple only if not yet existing
	 * @param triple
	 */
	public void createResourceOrUpdate(List<Triple> triples) {

		try {
			Map<String,Model> resources = new HashMap<String, Model>();

			for (Triple triple : triples) {
				String subj = triple.getSubject().getURI();
				if (resources.containsKey(subj)) {
					resources.get(subj).add(tripleToModel(triple) );
				} else {
					resources.put(subj, tripleToModel(triple) );
				}
			}

			for (Model new_data : resources.values()) {

				LdpResponse response = sendGET(new_data.listStatements().next().getSubject().getURI());
				if (response.getModel().isEmpty()) {
					sendPOST(containerURL, new_data);
				} else if (!isIncluded(new_data, response.getModel())) {
					new_data.add(response.getModel());
					sendPUT(response, new_data);
					//sendPut(container, body, proposedRessourceName, old_triples);
				}
			}

		} catch (Exception e) {
			StepLogger.getLogger().error(e);
		}
	}


	@Override
	public void sendTriple(Triple triple) {

		//		String body = "";
		//		if (triple.getObject().isURI()) {
		//			body = "<" + triple.getSubject().getURI() + "> <" + triple.getPredicate().getURI() + "> <" + triple.getObject().getURI() + "> . ";
		//		} else if (triple.getObject().isLiteral()) {
		//			body = "<" + triple.getSubject().getURI() + "> <" + triple.getPredicate().getURI() + "> " + triple.getObject().getLiteral() + " . ";
		//		}
		//		String proposedRessourceName = triple.getSubject().getURI().replace(containerURL, "");

		try {
			List<Triple> triples = new ArrayList<Triple>();
			triples.add(triple);
			createResourceOrUpdate(triples);

			sendGET(triple.getSubject().getURI());

		} catch (Exception e) {
			StepLogger.getLogger().error(e);
		}

	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	/*-------------------------------------- HTTP Section ---------------------------------------------------------*/
	/*-------------------------------------------------------------------------------------------------------------*/
	

	private void sendPOST(String url, Model new_data) throws Exception {

		StmtIterator iter = new_data.listStatements();
		Resource subj = null;
		while (iter.hasNext()) {
			Statement stmt = iter.next();
			if (subj == null) subj = stmt.getSubject();
			if (!subj.getURI().equalsIgnoreCase(stmt.getSubject().getURI())) 
				throw new IllegalArgumentException("Subject of triple " + stmt.asTriple().toString() + " does not fit to other subjects (" + subj.getURI() + "). "
						+ "In order to create a LDP Resource, use only triples with the same subject.");
		}

		HttpURLConnection con = (HttpURLConnection) (new URL(url)).openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Link", "<http://www.w3.org/ns/ldp#Resource>; rel=\"type\"");
		con.setRequestProperty("Slug", getLocaleId(subj.getURI(), namespace));
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "text/turtle");
		con.setRequestProperty("Accept", "text/turtle");
		String userpass = user + ":" + pwd;
		String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());
		con.setRequestProperty ("Authorization", basicAuth);

		//create data part
		String body = convertJenaModelToTurtle(new_data);

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(body);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		StepLogger.getLogger().debug("\nSending 'POST' request to URL : " + url);
		StepLogger.getLogger().debug("Header : " + con.getRequestProperties());
		StepLogger.getLogger().debug("Body : " + body);
		StepLogger.getLogger().debug("Response Code : " + responseCode);

		Map<String, List<String>> headerFields = con.getHeaderFields();
		headerFields.forEach( (header, value)  -> StepLogger.getLogger().info(header + ": " + value) );
		String location = headerFields.get("Location").get(0);
		if (!location.equalsIgnoreCase(subj.getURI())) {
			StepLogger.getLogger().warn("Attention! Resource URL changed from " + subj.getURI() + " to " + location);
		}

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		StepLogger.getLogger().info(response.toString());
	}


	private void sendPUT(LdpResponse ldp_response, Model new_data) throws Exception {

		StmtIterator iter = new_data.listStatements();
		Resource subj = null;
		while (iter.hasNext()) {
			Statement stmt = iter.next();
			if (subj == null) subj = stmt.getSubject();
			if (!subj.getURI().equalsIgnoreCase(stmt.getSubject().getURI())) 
				throw new IllegalArgumentException("Subject of triple " + stmt.asTriple().toString() + " does not fit to other subjects (" + subj.getURI() + "). "
						+ "In order to execute PUT on a LDP Resource, use only triples with the same subject.");
		}
		if (!subj.getURI().equalsIgnoreCase(ldp_response.getLocation())) 
			throw new IllegalArgumentException("Subject " + subj + " of resource to change does not fit the target resource of PUT request (" + ldp_response.getLocation() + "). "
					+ "In order to execute PUT on a LDP Resource, use only subject that match the resource.");

		HttpURLConnection con = (HttpURLConnection) (new URL(ldp_response.getLocation())).openConnection();

		//add reuqest header
		con.setRequestMethod("PUT");
		con.setRequestProperty("Link", "<http://www.w3.org/ns/ldp#Resource>; rel=\"type\"");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "text/turtle");
		con.setRequestProperty("Accept", "text/turtle");
		con.setRequestProperty("If-Match", ldp_response.geteTag());
		String userpass = user + ":" + pwd;
		String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());
		con.setRequestProperty ("Authorization", basicAuth);



		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		String body = convertJenaModelToTurtle(new_data);
		wr.writeBytes(body);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		StepLogger.getLogger().debug("\nSending 'PUT' request to URL : " + ldp_response.getLocation());
		StepLogger.getLogger().debug("Header : " + con.getRequestProperties());
		StepLogger.getLogger().debug("Body : " + body);
		StepLogger.getLogger().debug("Response Code : " + responseCode);

		Map<String, List<String>> headerFields = con.getHeaderFields();
		headerFields.forEach( (header, value)  -> StepLogger.getLogger().info(header + ": " + value) );

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		StepLogger.getLogger().info(response.toString());

	}


	private LdpResponse sendGET(String url) {

		Model model = ModelFactory.createDefaultModel();
		String location = url;
		String eTag = "";

		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			//add accept header
			//con.setRequestProperty("Accept", "application/rdf+xml");
			con.setRequestProperty("Accept", "text/turtle");

			int responseCode = con.getResponseCode();
			StepLogger.getLogger().info("\nSending 'GET' request to URL : " + url);
			StepLogger.getLogger().info("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuffer response = new StringBuffer();	

			model.read(con.getInputStream(), null, "TTL");
			eTag = con.getHeaderField("ETag");
			
			in.close();

			con.disconnect();

			//print result
			StepLogger.getLogger().info(response.toString());

		} catch (Exception e) {
			StepLogger.getLogger().warn(e);
		}

		return new LdpResponse(location, model, eTag);

	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	/*----------------------------------- Supporting methods ------------------------------------------------------*/
	/*-------------------------------------------------------------------------------------------------------------*/

	private boolean isIncluded(Model new_data, Model old_data) {
		return old_data.containsAll(new_data);
	}

	private String tripleSetToString(List<Triple> triples) {
		String text = "";

		for (Triple triple : triples) {
			text += tripleToString(triple);
		}

		return text;
	}
	private String convertJenaModelToTurtle(Model model) {
		String syntax = "TURTLE";
		StringWriter out = new StringWriter();
		model.write(out, syntax);
		return out.toString();
	}

	private String tripleToString(Triple triple) {
		String text = "";
		if (triple.getObject().isURI()) {
			text = "<" + triple.getSubject().getURI() + "> <" + triple.getPredicate().getURI() + "> <" + triple.getObject().getURI() + "> . ";
		} else if (triple.getObject().isLiteral()) {
			text = "<" + triple.getSubject().getURI() + "> <" + triple.getPredicate().getURI() + "> \"" + triple.getObject().getLiteral() + "\" . ";
		}

		return text;
	}
	private Model tripleToModel(Triple triple) {
		Model model = ModelFactory.createDefaultModel();
		
		if (triple.getObject().isURI()) {
			model.add(model.createResource(triple.getSubject().getURI()),
					model.createProperty(triple.getPredicate().getURI()),
					model.createResource(triple.getObject().getURI()));
		} else if (triple.getObject().isLiteral()) {
			model.add(model.createResource(triple.getSubject().getURI()),
					model.createProperty(triple.getPredicate().getURI()),
					model.createLiteral(triple.getObject().getLiteral().toString()));
		}
		
		return model;
	}

	private boolean isIncluded(Triple triple, List<Triple> triples) {
		String subj1 = triple.getSubject().getURI().toString();
		String pred1 = triple.getPredicate().getURI().toString();
		String obj1 = "";
		if (triple.getObject().isLiteral()) {obj1 = triple.getObject().getLiteralValue().toString();} else {obj1 = triple.getObject().getURI().toString();}

		for (Triple t : triples) {
			String subj2 = t.getSubject().getURI().toString();
			String pred2 = t.getPredicate().getURI().toString();
			String obj2 = "";
			if (t.getObject().isLiteral()) {obj2 = t.getObject().getLiteralValue().toString();} else {obj2 = t.getObject().getURI().toString();}

			if (!subj1.equalsIgnoreCase(subj2)) continue;
			if (!pred1.equalsIgnoreCase(pred2)) continue;
			if (!obj1.equalsIgnoreCase(obj2)) continue;

			return true;
		}

		return false;
	}
	
	private String getLocaleId(String url, String namespace) {
		url = url.replace(namespace, "");
		if (url.startsWith("/")) url = url.substring(1, url.length());
		url = url.replace("/", "-");
		return url;
	}

}
