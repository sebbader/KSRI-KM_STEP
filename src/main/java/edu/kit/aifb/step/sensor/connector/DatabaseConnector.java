package edu.kit.aifb.step.sensor.connector;

import java.util.List;

import org.apache.jena.graph.Triple;
import org.apache.jena.rdf.model.Model;

import virtuoso.jdbc4.VirtuosoException;

public interface DatabaseConnector {
	
	public void sendTriple (String subject, String predicate, String object);
	public void sendQuadruple (Triple triple, String graphname);
	public void sendTriple(Triple triple);
	void sendTriples(List<Triple> triples);
	public void sendTriples(Model model);

}
