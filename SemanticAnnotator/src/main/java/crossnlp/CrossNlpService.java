package crossnlp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * Class to call the CrossNlpPipeline
 * @author sba
 *
 */
public class CrossNlpService {
	
	private String url;
	
	
	public CrossNlpService() {
		this.url = "http://scc-cnor-129py5.scc.kit.edu:9080";
	}

	
	
	
	
	public List<String> callNER(String chars) throws IOException {
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "1");
		jsonObject.put("title", "no title");
		jsonObject.put("body", chars);
		jsonObject.put("tags", new JSONArray("[\"no tags\"]"));
		

		String url = this.url + "/nlp/general/ner";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");


		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(jsonObject.toString());
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + jsonObject.toString());
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());


		
		//get all headers
		Map<String, List<String>> map = con.getHeaderFields();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() +
		                 " ,Value : " + entry.getValue());
		}

		//get header by 'key'
		String resource = con.getHeaderField("Location").replaceAll("\\s", "");
		
		
		
		
		
		
		//=====================================================================
		//		service successfully invoked
		//		now GET created resource
		//=====================================================================
		
		
		
		
		
		URL url_obj = new URL(resource);
		con = (HttpURLConnection) url_obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		//con.setRequestProperty("User-Agent", USER_AGENT);

		responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		in = new BufferedReader( new InputStreamReader(con.getInputStream()) );
		response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		
		JSONObject jsonObj = new JSONObject(response.toString());
		List<String> suggestions = getWords( jsonObj );
		
		return suggestions;
	}
	
	
	
	private List<String> getWords(JSONObject jObject) {
		List<String> words = new ArrayList<String>();
		Iterator<?> keys = jObject.keys();

		while( keys.hasNext() ) {
		    String key = (String)keys.next();
		    
		    if (key.equalsIgnoreCase("nif:anchorOf")) {
		    	words.add(jObject.getString(key));
		    } 
		    
		    else if ( jObject.get(key) instanceof JSONObject ) {
		    	
		    	words.addAll( getWords( (JSONObject) jObject.get(key)) );
		    	
		    }
		    
		    else if ( jObject.get(key) instanceof JSONArray ) {
		    	
		    	words.addAll( getWords( (JSONArray) jObject.get(key)) );
		    	
		    }
		}
		
		return words;
	}


	private List<String> getWords(JSONArray jsonArray) {
		List<String> words = new ArrayList<String>();
		
		for (int i = 0; i < jsonArray.length(); i++) {
			
		    if ( jsonArray.get(i) instanceof JSONObject ) {
		    	
		    	words.addAll( getWords( (JSONObject) jsonArray.get(i) ));
		    	
		    }
		    
		    else if ( jsonArray.get(i) instanceof JSONArray ) {
		    	
		    	words.addAll( getWords( (JSONArray) jsonArray.get(i) ) );
		    	
		    }
		}
		
		return words;
	}

}
