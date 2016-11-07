package edu.kit.aifb.step.server.connectortest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.graph.Triple;
import org.apache.jena.vocabulary.RDF;
import org.junit.Test;
import org.openrdf.rio.datatypes.RDFDatatypeHandler;

import edu.kit.aifb.step.Config;
import edu.kit.aifb.step.StepLogger;
import edu.kit.aifb.step.sensor.AdministrationShell.AdministrationShell;
import edu.kit.aifb.step.sensor.connector.DatabaseConnector;
import edu.kit.aifb.step.sensor.connector.LinkedDataPlatformConnector;
import junit.framework.TestCase;

public class LinkedDataPlatformConnectorTest {

//	@Test
//	public void sendTriplesTest() {
//		String number = "7";
//
//		StepLogger.setLogger();
//		DatabaseConnector connector = new LinkedDataPlatformConnector("scc-cnor-129py5.scc.kit.edu", "8080", "anonymous", "Password1", "http://km.aifb.kit.edu/projects/step");
//		
//		List<Triple> triples = new ArrayList<Triple>();
//		
//		triples.add( new Triple(NodeFactory.createURI("http://scc-cnor-129py5.scc.kit.edu:8080/marmotta/ldp/LdpDummy" + number), 
//				NodeFactory.createURI("http://www.w3.org/2000/01/rdf-schema/label"),
//				NodeFactory.createLiteral("ldp dummy " + number) )
//				);
//		
//		triples.add( new Triple(NodeFactory.createURI("http://scc-cnor-129py5.scc.kit.edu:8080/marmotta/ldp/LdpDummy" + number), 
//				NodeFactory.createURI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"),
//				NodeFactory.createURI("http://example.org/Dummy") ) 
//				);
//		
//		triples.add( new Triple(NodeFactory.createURI("http://scc-cnor-129py5.scc.kit.edu:8080/marmotta/ldp/LdpDummy" + number), 
//				NodeFactory.createURI("http://www.w3.org/1999/02/22-rdf-syntax-ns#value"),
//				NodeFactory.createLiteral("42") )
//				);
//		
//		
//		connector.sendTriples(triples);
//		
//		assertTrue(true);
//	}
	
	
	@Test
	public void sendTriplesTest() {

		StepLogger.setLogger();
		Config config = new Config();
		config.setLDPContainer("http://scc-cnor-129py5.scc.kit.edu:8080/marmotta/ldp");
		
		DatabaseConnector connector = new LinkedDataPlatformConnector(config);
		
		Triple	triple = new Triple(NodeFactory.createURI("http://172.22.177.6:8080/marmotta/ldp/LdpDummy3"), 
				NodeFactory.createURI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"),
				NodeFactory.createLiteral("<http://example.org/Dummy>") ) ;
		
		List<Triple> triples = new ArrayList<Triple>();
		triples.add(triple);
		
		connector.sendTriples(triples);

	}

	
}
