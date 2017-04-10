package main.java.web;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.jsonldjava.core.JsonLdError;
import com.github.jsonldjava.core.JsonLdOptions;
import com.github.jsonldjava.core.JsonLdProcessor;
import com.github.jsonldjava.utils.JsonUtils;

@Path("jsonld-parser")
public class JSONParser {
	
	/**
	 * http://localhost:8080/semantic-annotator/test/jsonld-parser
	 * @return
	 */
	
	@GET
	public String sayHello() {
		return "Hello!";
	}

	@POST
//	@Produces("application/json-ld")
//	@Consumes(MediaType.TEXT_PLAIN)
	public String parseJSONLD(String text) throws IOException, JsonLdError {
		
		// Open a valid json(-ld) input file
		/*InputStream inputStream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
		
		// Read the file into an Object (The type of this object will be a List, Map, String, Boolean,
		// Number or null depending on the root object in the file).
		Object jsonObject = JsonUtils.fromInputStream(inputStream);
		
		// Create a context JSON map containing prefixes and definitions
		Map context = new HashMap();
		
		// Customise context...
		// Create an instance of JsonLdOptions with the standard JSON-LD options
		JsonLdOptions options = new JsonLdOptions();
		
		// Customise options...
		// Call whichever JSONLD function you want! (e.g. compact)
		Object compact = JsonLdProcessor.compact(jsonObject, context, options);
		
		// Print out the result (or don't, it's your call!)
		//return JsonUtils.toPrettyString(compact);*/
		
		System.out.println(text);
		
		return "hui";

	}
	
}
