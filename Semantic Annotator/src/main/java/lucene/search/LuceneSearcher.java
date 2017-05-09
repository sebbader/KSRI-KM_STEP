package main.java.lucene.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.semanticweb.yars.nx.Node;

import com.ontologycentral.nxindexer.keyword.KeywordSearcher;

public class LuceneSearcher {

	public static void main(String[] args) {
		LuceneSearcher searcher = new LuceneSearcher();

		String query = "Taucwalz~";
//		query = "Tauch*";
//		String field = "water";
		try {

			Map<Node, Float> nodes = searcher.search(query);
			
			//RDF: (Subject, Predicate, Object) --> ["Subject", "Predicate", "Object"]
			// RDF graph: {rdf-triples*} --> List<Node[]>
			List<Node[]> l = new ArrayList<Node[]>();
			
			// Ausgabe
			System.out.println(nodes);
			// return l; (Methodenaufruf)
			// return Response.ok( l ).build();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Map<Node, Float> search(String query) throws IOException {
		KeywordSearcher searcher = new KeywordSearcher("resources/StepOntologyIndex/lucene");
		Map<Node, Float> results = searcher.getResults(query, 10);
		return results;
	}






	
}
