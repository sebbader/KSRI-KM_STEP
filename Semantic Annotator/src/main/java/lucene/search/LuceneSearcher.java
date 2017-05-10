package main.java.lucene.search;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.semanticweb.yars.nx.Literal;
import org.semanticweb.yars.nx.Node;
import org.semanticweb.yars.nx.Resource;

import com.ontologycentral.nxindexer.keyword.KeywordSearcher;


public class LuceneSearcher {

	private String indexLocation;
	
	
	public static void main(String[] args) {
		LuceneSearcher searcher = new LuceneSearcher("resources/StepOntologyIndex/lucene");

		String query = "System~";
//		query = "Tauch*";
//		String field = "water";
		try {

			List<Node[]> l = searcher.search(query);
			
			
			for ( Iterator<Node[]> iter = l.iterator(); iter.hasNext(); ) {
				
				Node[] node = iter.next();
				
				System.out.println(node[0]
						+ " " + node[1]
						+ " " + node[2] + " ." );
				
			}
			
					
			// Ausgabe
			//System.out.println(l);
			// return l; (Methodenaufruf)
			// return Response.ok( l ).build();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public LuceneSearcher(String indexLocation) {
		this.indexLocation = indexLocation;
	}
	
	

	public List<Node[]> search(String query) throws IOException {
		
		KeywordSearcher searcher = new KeywordSearcher(indexLocation);
		Map<Node, Float> results = searcher.getResults(query, 10);
		
		results = sortByValue(results);
		
		
		// RDF: (Subject, Predicate, Object) --> Node["Subject", "Predicate", "Object"]
		// RDF graph: {rdf-triples*} --> List<Node[]>
		List<Node[]> graph = new ArrayList<Node[]>();
		
		
		for ( Iterator<Node> iter = results.keySet().iterator(); iter.hasNext(); ) {
			
			Node subj = iter.next();
			
			graph.add( new Node[] { subj, new Resource("http://people.aifb.kit.edu/mu2771/step#hasScore"), new Literal("\"" + results.get(subj) + "\"") } );
						
		}
		
		
		return graph;
	}




	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
	    return map.entrySet()
	              .stream()
	              .sorted(Entry.comparingByValue(Collections.reverseOrder()))
	              .collect(Collectors.toMap(
	                Map.Entry::getKey, 
	                Map.Entry::getValue, 
	                (e1, e2) -> e1, 
	                LinkedHashMap::new
	              ));
	}


	
}
