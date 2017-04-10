package main.java.bridgepattern;

import java.util.ArrayList;

public class BridgePattern {
	
	public ArrayList<String> triples;
	public ArrayList<String> query;
	public ArrayList<String> entities;
	public ArrayList<String> sen_var_ent;
	
	private String part;
	
	
	
	public BridgePattern() {
		triples = new ArrayList<String>();
		query = new ArrayList<String>();
		entities = new ArrayList<String>();
		sen_var_ent = new ArrayList<String>();
	}



	public String getPart() {
		return part;
	}



	public void setPart(String part) {
		this.part = part;
	}
	
	

}
