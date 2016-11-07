package edu.kit.aifb.step;

import org.apache.jena.rdf.model.Model;

public class LdpResponse {
	
	private Model model;
	private String location;
	private String eTag;
	
	public LdpResponse(String location, Model model, String eTag) {
		this.location = location;
		this.model = model;
		this.eTag = eTag;
	}
	
	
	
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String geteTag() {
		return eTag;
	}
	public void seteTag(String eTag) {
		this.eTag = eTag;
	}
	
	

}
