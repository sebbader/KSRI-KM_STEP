package crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.glassfish.jersey.client.ClientRequest;
import org.glassfish.jersey.client.JerseyInvocation;
import org.glassfish.jersey.message.internal.MessageBodyFactory;
import org.json.JSONObject;
import org.semanticweb.yars.jaxrs.JsonLdMessageBodyReaderWriter;
import org.semanticweb.yars.nx.BNode;
import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.Resource;
import org.semanticweb.yars.nx.namespace.RDF;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;

public class App {

	public static void main(String[] args) throws UnsupportedOperationException, URISyntaxException, IOException {

		App app = new App();
		try {
			app.runCrawler();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void runCrawler() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, URISyntaxException, UnsupportedOperationException, IOException {

		// Status: hier alle informationen über Java zugreifbar

		
		
		
		// JAX RS Client
		HttpClient client = HttpClientBuilder.create().build();

		// client macht seinen Call
		HttpGet req = new HttpGet();
		req.setURI(new URI("http://api.stackexchange.com/2.2/info?site=stackoverflow"));
		req.setHeader("Accept", "application/json");

		

		HttpResponse response = client.execute(req);

		
		
		// responses werden gelesen
		String data = "";
		InputStream body = response.getEntity().getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader( body ) );
		String line = "";
		while ((line = br.readLine()) != null) {
		    data += line + "\n";
		}
		br.close();	
		
		JSONObject json = new JSONObject(data);
	
		//System.out.println(json.toString());
		

		// als rdf über return zurückgegeben
	}

}
