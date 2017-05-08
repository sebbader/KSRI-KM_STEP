package main.java.lucene.search;

import java.io.IOException;
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
			
			System.out.println(nodes);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Map<Node, Float> search(String query) throws IOException {
		KeywordSearcher searcher = new KeywordSearcher("/home/sba/Documents/1_STEP/Ontologien/Index/lucene");
		Map<Node, Float> results = searcher.getResults(query, 10);
		return results;
	}






//	public List<Node> luceneSearch(String query_string, String field) throws IOException, ParseException {
//
//		IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get("/home/sba/Documents/1_STEP/Ontologien/Index")));
//		IndexSearcher searcher = new IndexSearcher(reader);
//
//		/* 
//		 * 2. build an analyzer again - use the same as in the indexing process
//		 */
//		Analyzer analyzer = new StandardAnalyzer();
//
//		/*
//		 * 3. Build a query parser who will parse our query, written in Lucene Query Language 
//		 */
//		QueryParser parser = new QueryParser(field, analyzer);
//
//		/*
//		 * 4. we search the value in a given field, e.g. "versioninfo:LUCENE-5945"
//		 */
//		Query query = parser.parse(field + ":" + query_string);
//
//		/*
//		 * 5. we trigger the search, interested in the 5 first matches
//		 */
//		TopDocs results = searcher.search(query, 5);
//
//		/*
//		 * 6. We get the hit information via the scoreDocs attribute in the TopDocs object
//		 */
//		ScoreDoc[] hits = results.scoreDocs;	    
//		int numTotalHits = results.totalHits;
//		System.out.println(numTotalHits + " total matching documents");
//
//		if (hits.length > 0) {
//			/*
//			 * Matching score for the first document
//			 */
//			System.out.println("Matching score for first document: " + hits[0].score);
//
//			/*
//			 * We load the document via the doc id to be found in the ScoreDoc.doc attribute
//			 */
//			Document doc = searcher.doc(hits[0].doc);
//			System.out.println("Id of the document: " + doc.get("id"));
//		}	    
//
//		return null;
//	}
	
}
