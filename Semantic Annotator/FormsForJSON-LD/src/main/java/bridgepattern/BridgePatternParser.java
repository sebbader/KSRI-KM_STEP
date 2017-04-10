package main.java.bridgepattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.jena.system.JenaSystem;

import virtuoso.jena.driver.*;


public class BridgePatternParser {

	private String default_graph = "<http://people.aifb.kit.edu/sba/step>";
	
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
		BridgePattern bridgepattern = new BridgePattern();

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
				bridgepattern.entities.add(line.toString());
			} else if (status.equalsIgnoreCase("sen_var_ent") ) {
				bridgepattern.sen_var_ent.add(line.toString());
			} else if (status.equalsIgnoreCase("triples") ) {
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
		

		String query = "INSERT INTO GRAPH " + this.default_graph + " { ";

		for (String line : bridgepattern.query) {
			query += line.replace("?G_0", "<http://G0>").replaceAll("\\?S[0-9]*", "<http://S>") + "\n";
		}
		
		
		query += "}";
		System.out.println("\nexecute: " + query );

//		System.out.println("\nexecute: INSERT INTO GRAPH <http://test1> { <aa> <bb> 'cc' . <aa1> <bb1> 123. }");
//        String str = "INSERT INTO GRAPH <http://test1> { <aa> <bb> 'cc' . <aa1> <bb1> 123. }";
//        VirtuosoUpdateRequest  vur0 = VirtuosoUpdateFactory.create(str, graph);
//        vur0.exec();      
        
		VirtuosoUpdateRequest vur = VirtuosoUpdateFactory.create(query, graph);
		vur.exec();   


	}

}
