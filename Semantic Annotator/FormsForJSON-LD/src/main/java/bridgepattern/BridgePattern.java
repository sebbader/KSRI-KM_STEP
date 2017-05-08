package main.java.bridgepattern;

import java.util.ArrayList;

public class BridgePattern {
	
	public ArrayList<String> triples;
	public ArrayList<String> query;
	public ArrayList<String> entities;
	public ArrayList<String> sen_var_ent;
	
	private String part;
	private String id;
	private String uri;
	
	
	
	public BridgePattern() {
		triples = new ArrayList<String>();
		query = new ArrayList<String>();
		entities = new ArrayList<String>();
		sen_var_ent = new ArrayList<String>();
	}	
	
	public BridgePattern(String id, String namespace) {
		this.id = id;
		this.setUri(namespace + id);
		this.triples = new ArrayList<String>();
		this.query = new ArrayList<String>();
		this.entities = new ArrayList<String>();
		this.sen_var_ent = new ArrayList<String>();
	}



	public String getPart() {
		return part;
	}



	public void setPart(String part) {
		this.part = part;
	}



	public String getId() {
		return id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}	
	

}
