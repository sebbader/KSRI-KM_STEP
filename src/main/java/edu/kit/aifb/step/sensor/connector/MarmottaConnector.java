package edu.kit.aifb.step.sensor.connector;

import java.util.List;

import org.apache.jena.graph.Triple;
import org.apache.jena.rdf.model.Model;

import virtuoso.jdbc4.VirtuosoException;

public class MarmottaConnector implements DatabaseConnector {

	@Override
	public void sendTriple(String subject, String predicate, String object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendQuadruple(Triple triple, String graphname) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendTriple(Triple triple) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendTriples(List<Triple> triples) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendTriples(Model model) {
		// TODO Auto-generated method stub
		
	}


}
