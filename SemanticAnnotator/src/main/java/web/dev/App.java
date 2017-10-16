package web.dev;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientRequest;
import org.glassfish.jersey.client.JerseyInvocation;
import org.semanticweb.yars.jaxrs.JsonLdMessageBodyReaderWriter;
import org.semanticweb.yars.nx.BNode;
import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.Resource;
import org.semanticweb.yars.nx.namespace.RDF;

import namespaces.STEP;

public class App {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {



		// Status: hier alle informationen über Java zugreifbar

		// JAX RS Client
		//		Client client = ClientBuilder.newClient();
		Client client = ClientBuilder.newBuilder().register(JsonLdMessageBodyReaderWriter.class).build();

		// client macht seinen Call

		Iterable<Node[]> list = new LinkedList<Node[]>() {};
		((LinkedList<Node[]>) list).add(new Node[] { new BNode(""), RDF.TYPE, new Resource(STEP.NS + "AppDev" ) });


		JerseyInvocation.Builder b = (org.glassfish.jersey.client.JerseyInvocation.Builder) client
				.target("http://localhost:8080/SemanticAnnotator/autocomplete")
				.request( JsonLdMessageBodyReaderWriter.JSONLD_MEDIATYPE );
		
		
		Method m = b.getClass().getDeclaredMethod("request");
		m.setAccessible(true);// Abracadabra 
		ClientRequest cr = (ClientRequest) m.invoke(b);// now its OK
		
		
		
		cr.setEntityType(list.getClass().getGenericSuperclass());

		JerseyInvocation bla = (JerseyInvocation) b.buildPost(Entity.entity(new GenericEntity<Iterable<Node[]>>( list ) { },JsonLdMessageBodyReaderWriter.JSONLD_MEDIATYPE ));

		cr.accept( JsonLdMessageBodyReaderWriter.JSONLD_MEDIATYPE );
		
		//cr.setEntityType(list.getClass().getGenericSuperclass());
		Response response = bla.invoke();
		

		Iterable<Node[]> data = response.readEntity(  new GenericType<Iterable<Node[]>>(  ) { } ) ;		
		for (Iterator<Node[]> iter = data.iterator(); iter.hasNext() ; ) {
			Node[] node = iter.next();
			System.out.println("Node: " + node[0] + node[1] + node[2]);
		}

		// responses werden gelesen

		// als rdf über return zurückgegeben


	}


}
