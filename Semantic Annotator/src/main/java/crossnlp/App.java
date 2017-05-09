package src.main.java.crossnlp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.semanticweb.yars.nx.Node;

/**
 * A Client to trigger the CrossNlpPipeline
 * @author sba
 *
 */
public class App {
	
	public static void main(String args[]) {
		

		App app = new App();
		
		
		// Test1:
//		List<String> suggestions1 = app.getSuggestions("As");
//		System.out.println(suggestions1);
//		
//		
//
//		// Test2:
//		List<String> suggestions2 = app.getSuggestions("Aspir");
//		System.out.println(suggestions2);
//		
//		
//
//		// Test3:
//		List<String> suggestions3 = app.getSuggestions("Aspirin");
//		System.out.println(suggestions3);
//		
//
//
		// Test4:
		List<String> suggestions4 = app.getSuggestions("Aspirin is a very effective drug for many medical use cases in Great Britain.");
		System.out.println(suggestions4);
		


		// Test5:
		List<String> suggestions5 = app.getSuggestions("Java is an implementation framework, develloped by Donald Trump and used by IBM, SAP and Karslruhe Institute of Technology");
		System.out.println(suggestions5);
		

		//RDF: (Subject, Predicate, Object) --> ["Subject", "Predicate", "Object"]
		// RDF graph: {rdf-triples*} --> List<Node[]>
		List<Node[]> l = new ArrayList<Node[]>();
		
		// Ausgabe
		// return l; (Methodenaufruf)
		// return Response.ok( l ).build();
		
	}
	
	
	public List<String> getSuggestions(String chars) {
		List<String> suggestions = new ArrayList<String>();
		
		
		CrossNlpService service = new CrossNlpService();
		try {
			suggestions.addAll( service.callNER(chars) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return suggestions;
	}

}
