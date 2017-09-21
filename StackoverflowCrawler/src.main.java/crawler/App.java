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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
//import org.glassfish.jersey.client.ClientRequest;
//import org.glassfish.jersey.client.JerseyInvocation;
//import org.glassfish.jersey.message.internal.MessageBodyFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
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
		req.setURI(new URI("http://api.stackexchange.com/2.2/questions?pagesize=10&order=desc&sort=creation&site=stackoverflow&filter=!-MOiNm40F1U6n0W_ddI6qTnlVA_avvcf_&key=UD1r0MHBsSgNCXkO0Ek5Tg(("));
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
		
		JSONObject jsonStack = new JSONObject(data);
		JSONArray items = jsonStack.getJSONArray("items");
		
		String[] questionStacks = new String[items.length()];
		
		for (int i = 0; i < items.length(); i++) {
			JSONObject item = (JSONObject) items.get(i);
			
			System.out.println("New Question:");
			System.out.println(item.toString() + "\n");
			
//			Frage wird von HTML Tags und Code-Fragmenten bereinigt
			String questionStack = (String) item.get("body");
		    String cleanQuestionStack = questionStack.replaceAll("<code>[\\w\\W]+</code>", "");
			questionStacks[i] = Jsoup.parse(cleanQuestionStack).text();
			System.out.println(questionStacks[i] + "\n");
			item.put("body", questionStacks[i]);
			
			
			//Frage wird als JSON ausgegeben
			System.out.println(items.get(i).toString()+ "\n");
			
			
			StringEntity params = new StringEntity(items.get(i).toString());
			
			//Sende Post Request an xDomain
			HttpPost post = new HttpPost();
			post.setURI(new URI("http://aifb-ls3-vm1.aifb.kit.edu:9080/nlp/stackoverflow/ner"));
			post.setHeader("Content-type", "application/json");
			post.setEntity(params);
			
			HttpResponse response2 = client.execute(post);
			
//			Mongo-Datenbankadresse wird ausgelesen
			String location = response2.getHeaders("location")[0].getValue();
			
			System.out.println(location + "\n");
			
			
//			Get-Reqeuest an die Datenbank senden
			HttpGet getEntities = new HttpGet();
			getEntities.setHeader("Accept", "application/json");
			getEntities.setURI(new URI(location));
			
			HttpResponse responseEntites = client.execute(getEntities);
			
//			Response mit Entities auslesen
			String entites = "";
			InputStream bodies = responseEntites.getEntity().getContent();
			BufferedReader rt = new BufferedReader(new InputStreamReader( bodies ) );
			line = "";
			while ((line = rt.readLine()) != null) {
			    entites += line + "\n";
			}
			rt.close();	
			
			JSONObject jsonEntities = new JSONObject(entites);
			StringEntity paramsLDP = new StringEntity(jsonEntities.toString());
			System.out.println(jsonEntities.toString() + "\n\n");
			
			
//			Post auf LDP Datenbank
			HttpPost postLDP = new HttpPost();
			postLDP.setURI(new URI("http://aifb-ls3-vm1.aifb.kit.edu:8080/marmotta/ldp/StackOverflow"));
			postLDP.setHeader("Content-type", "application/ld+json");
			postLDP.setHeader("Slug", "StackoverflowQuestion");
			postLDP.setEntity(paramsLDP);
			
			HttpResponse responseLDP = client.execute(postLDP);
			
		}
		
	}

}
