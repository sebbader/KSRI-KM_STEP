package edu.kit.aifb.step.sensor.connector;

import java.util.List;

import org.apache.jena.graph.Node;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.graph.Triple;
import org.apache.jena.rdf.model.Model;

import edu.kit.aifb.step.StepLogger;
import edu.kit.aifb.step.sensor.AdministrationShell.AdministrationShell;
import edu.kit.aifb.step.sensor.converter.JsonConverter;
import virtuoso.jena.driver.VirtGraph;

public class VirtuosoConnector implements DatabaseConnector {
	
	private static VirtGraph graph;

	//	private static String user = "dba";
	//	private static String pwd = "Password1";
	private String user = "step";
	private String pwd = "FirstStep";
	private String host = "localhost";
	private String port = "1111";

	private String graphname = "http://aifb.kit.edu/step";


	public VirtuosoConnector (String host, String port, String user, String pwd, String graphname) {

		this.host = host;
		this.port = port;
		this.user = user;
		this.pwd = pwd;
		this.graphname = graphname;

		graph = new VirtGraph (graphname, "jdbc:virtuoso://" + host + ":" + port, user, pwd);
		graph.close();
	}

	/**
	 * sends the triple to virtuoso.
	 * graph will be the default graph of the project (not the default graph of virtuoso)
	 * @param subject
	 * @param predicate
	 * @param object
	 */
	public void sendTriple (String subject, String predicate, String object) {	

		if (JsonConverter.isValidURL(object)) {
			sendQuadruple (
					new Triple(NodeFactory.createURI(subject), 
							NodeFactory.createURI(predicate),
							NodeFactory.createURI(object) ), 
							this.graphname);
		} else {
			sendQuadruple (
					new Triple(NodeFactory.createURI(subject), 
							NodeFactory.createURI(predicate),
							NodeFactory.createLiteral(object) ), 
							this.graphname);
		}

	}

	public void sendTriple(Triple triple) {

		sendQuadruple(triple, this.graphname);
	}

	public void sendQuadruple (Triple triple, String graphname) {		

		//TODO
		StepLogger.getLogger().debug("\nAttempt sending " + graphname + ": " + triple.getSubject() + " " + triple.getPredicate() + " " + triple.getObject());
		StepLogger.getLogger().debug("to Virtuoso DB: " + "jdbc:virtuoso://" + host + ":" + port + " " + user + " " + pwd);
		graph = new VirtGraph (graphname, "jdbc:virtuoso://" + host + ":" + port, user, pwd);
		StepLogger.getLogger().trace("graph.getCount() = " + graph.getCount());	

		StepLogger.getLogger().trace("Add a triple to graph " + graphname + ".");
		graph.add(triple);
		StepLogger.getLogger().trace("graph.getCount() = " + graph.getCount());		

		graph.close();
		
		StepLogger.getLogger().debug("Sent Tripel: " + triple.toString() + "\n");
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
