package main.java.bridgepattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.jena.system.JenaSystem;

import virtuoso.jena.driver.*;


public class BridgePatternParser {

	private String default_graph = "http://people.aifb.kit.edu/sba/step";

	private String host;
	private String port;
	private String user;
	private String pwd; 

	/**
	 * scc-cnor-129py5.scc.kit.edu
	 * 1111
	 * dba
	 * Password1
	 * /home/sba/Documents/1_STEP/AP5/Bridge_Pattern/en-step5-backup
	 */
	public static void main(String args[]) throws IOException {

		String host = args[0];
		String port = args[1];
		String user = args[2];
		String password = args[3];
		String path = args[4];

		BridgePatternParser parser = new BridgePatternParser(host, port, user, password);
		//		BridgePatternParser parser = new BridgePatternParser();

		File dir = new File(path);
		for (final File file : dir.listFiles()) {
			BridgePattern bridgePattern = parser.parse(file);
			parser.sendToServer(bridgePattern);
		}


	}



	public BridgePatternParser(String host, String port, String user, String password) {
		//		graph = new VirtGraph ("jdbc:virtuoso://scc-cnor-129py5.scc.kit.edu:1111", "dba", "Password1");
		this.host = host;
		this.port = port;
		this.user = user;
		this.pwd = password;
	}


	public BridgePattern parse(File file) throws IOException {

		BufferedReader fr = new BufferedReader(new FileReader(file));
		BridgePattern bridgepattern = new BridgePattern( URLEncoder.encode(file.getName(), "UTF-8"), default_graph + "/");

		String status = "---";
		for(String line; (line = fr.readLine()) != null; ) { 


			if (line.startsWith("QUERY")) {
				status = "query";
			} else if (line.contains("coverage")) {
				status = "coverage";
			} else if (line.contains("entities")) {
				status = "entities";
			} else if (line.contains("min_cov")) {
				status = "min_cov";
			} else if (line.contains("number_of_kernels")) {
				status = "number_of_kernels";
			} else if (line.contains("part")) {
				bridgepattern.setPart( line.toString() );
				status = "part";
			} else if (line.contains("sen_var_ent")) {
				status = "sen_var_ent";
			} else if (line.contains("triples")) {
				status = "triples";
			}

			if (status.equalsIgnoreCase("query") ) {
				if (line.contains("QUERY")) continue;
				if (line.contains("FILTER")) continue;

				bridgepattern.query.add(line.toString());


			} else if (status.equalsIgnoreCase("entities") ) {
				if (line.contains("entities")) continue;

				bridgepattern.entities.add(line.toString());


			} else if (status.equalsIgnoreCase("sen_var_ent") ) {
				if (line.contains("sen_var_ent")) continue;

				bridgepattern.sen_var_ent.add(line.toString());


			} else if (status.equalsIgnoreCase("triples") ) {
				if (line.contains("triples")) continue;

				bridgepattern.triples.add(line.toString());


			}

		}

		return bridgepattern;
	}


	public void sendToServer(BridgePattern bridgepattern) {

		JenaSystem.init();
		String driver = "jdbc:virtuoso://" + this.host + ":" + this.port;
		VirtGraph graph = new VirtGraph (driver, this.user, this.pwd);
		//		VirtGraph graph = new VirtGraph ("jdbc:virtuoso://scc-cnor-129py5.scc.kit.edu:1111", this.user, this.pwd);






		String query = "INSERT INTO GRAPH <" + this.default_graph + "> { "
				+ "<" + bridgepattern.getUri() + "> a <" + default_graph + "#BridgePattern> .\n"
				+ "<" + bridgepattern.getUri() + "> <" + default_graph + "#hasSubject> <" + bridgepattern.getUri() + "#subject> .\n"
				+ "<" + bridgepattern.getUri() + "#subject> <" + default_graph + "#hasBridgePattern> <" + bridgepattern.getUri() + "> .\n";






		// only 1000 elements are allowed in virtuoso SPARQL
		if (bridgepattern.query.size() > 949 ) bridgepattern.query = new ArrayList<String>( bridgepattern.query.subList(0, 948) );

		for (String line : bridgepattern.query) {
			if (line.matches(".*\".*\".*\".*") ) continue;
			query += line
					// replace ?G_x
					.replaceAll("\\?G_[0-9]+", "<" + bridgepattern.getUri() + "#subject>" )
					// replace ?Sx
					.replaceAll("\\?S[0-9]*", "<" + bridgepattern.getUri() + "#object>")
					.replaceAll("NAN", "0\\.0")
					+ "\n";
		}


		if (bridgepattern.getPart() == null) return;
		query += "<" + bridgepattern.getUri() + "> "
				+ "<" + default_graph + "#hasPart> "
				+ "\"\"\"" 
				+ bridgepattern.getPart()
					.replaceAll("part: ", "")
					.replaceAll("\"", "")
					.replaceAll("\\\\", "")
				+ "\"\"\" .\n";




		if (bridgepattern.entities.size() > 50) bridgepattern.entities = new ArrayList<String>( bridgepattern.entities.subList(0, 49) );

		for (String entity : bridgepattern.entities) {
			if (entity.matches(".*\".*\".*\".*") ) continue;
			query += "<" + bridgepattern.getUri() + "> "
					+
					"<" + default_graph + "#hasEntity> "
					+
					"<" + entity
					// replace 
					.replaceAll("[0-9]*:", "" )
					// replace 
					.replaceAll(":\\s[0-9]+", "" )
					.replaceAll("\"", "") 
					.replaceAll("'", "") 
					// replace 
					.replaceAll("\\s", "" )
					+ "> .\n";
		}





		query += "}";
		System.out.println("\nexecute: " + query );






		VirtuosoUpdateRequest vur = VirtuosoUpdateFactory.create(query, graph);
		vur.exec();   


	}

}
