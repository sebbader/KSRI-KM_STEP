package main.java.web;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.github.jsonldjava.core.JsonLdError;
import com.github.jsonldjava.core.JsonLdOptions;
import com.github.jsonldjava.core.JsonLdProcessor;
import com.github.jsonldjava.utils.JsonUtils;

@Path("jsonld-parser")
public class JSONParser {
	
	@GET
	public String sayHello() {
		return "Hello!";
	}

	@POST
//	@Produces("application/json-ld")
//	@Consumes(MediaType.TEXT_PLAIN)
	public String parseJSONLD(String text) throws IOException, JsonLdError {
		Object jsonObject = JsonUtils.fromString(text);
		// Create a context JSON map containing prefixes and definitions
		 Map<Object, Object> context = new HashMap<Object, Object>();
		 context.put("@vocab", "http://schema.org");
		 
		 /*context.put(2, "point");
		 Iterator<?> keys = jsonObject.keys();
		 while( keys.hasNext() ) {
			    String key = (String)keys.next();
			    if ( jsonObject.get(key) instanceof JSONObject ) {
			    	 context.put(jsonObject.get(key), jsonObject.get(key));
			    }
			}*/
		
		// Customise context...
		// Create an instance of JsonLdOptions with the standard JSON-LD options
		JsonLdOptions options = new JsonLdOptions();
		
		// Customise options...
		// Call whichever JSONLD function you want! (e.g. compact)
		Map<String, Object> compact = JsonLdProcessor.compact(jsonObject, context, options);
		
		// Print out the result (or don't, it's your call!)
		return JsonUtils.toPrettyString(compact);
	}
	
}
