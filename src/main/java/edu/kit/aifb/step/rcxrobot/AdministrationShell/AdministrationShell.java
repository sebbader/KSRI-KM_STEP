package edu.kit.aifb.step.rcxrobot.AdministrationShell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.jena.graph.Node;
import org.apache.jena.graph.Triple;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import edu.kit.aifb.step.StepLogger;


public class AdministrationShell {

	public static Logger logger;



	public static void main(String[] args) throws InterruptedException {

		logger = StepLogger.setLogger();
		
		AdministrationShell shell = new AdministrationShell();
		shell.start();
	}
	
	
	private void start() throws InterruptedException {
		
		while (true) {
			boolean isOn = checkStatus();

			if (isOn) {
				Program program = checkProgram();

				switch (program) {
				case none: 
					// do nothing
					break;
				case dummy:
					send("dll -e --tty=/dev/usb/legousbtower0 resources/rcx_programs/dummy.lx");
					break;
				case sound:
					send("dll -e --tty=/dev/usb/legousbtower0 resources/rcx_programs/sound.lx");
					break;
				case rover:
					send("dll -e --tty=/dev/usb/legousbtower0 resources/rcx_programs/rover.lx");
					break;
				default:
					logger.info("Could not identify program. Abort and continue reading");
					break;
				}
			}

			Thread.sleep(10000);
		}
	}


	private void send(String command) {

		try {
			//start the execution
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(command.split(" "));
			//output both stdout and stderr data from proc to stdout of this process
			StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream());
			StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream());
			errorGobbler.start();
			outputGobbler.start();
			proc.waitFor();


		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}


	private static Program checkProgram() {
		String url = "http://scc-cnor-129py5.scc.kit.edu:8080/marmotta/resource/RCX-PIMP";

		List<Triple> triples = new ArrayList<Triple>();

		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			//add accept header
			//con.setRequestProperty("Accept", "application/rdf+xml");
			con.setRequestProperty("Accept", "text/turtle");

			int responseCode = con.getResponseCode();
			logger.info("\nSending 'GET' request to URL : " + url);
			logger.info("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			StringBuffer response = new StringBuffer();

			//String inputLine;
			//		while ((inputLine = in.readLine()) != null) {
			//			response.append(inputLine);
			//		}
			//		
			//		
			Model model = ModelFactory.createDefaultModel();
			model.read(con.getInputStream(), null, "TTL");
			StmtIterator iter = model.listStatements();
			while (iter.hasNext()) {
				Statement statement = iter.next();
				triples.add(statement.asTriple());
				response.append(statement.toString());
			}

			in.close();

			con.disconnect();

			//print result
			logger.debug(response.toString());

			for (Triple triple : triples) {
				if (triple.getPredicate().getURI().equalsIgnoreCase("http://example.org/program")) {
					if (triple.getObject().getLiteral().toString().equalsIgnoreCase("dummy")) return Program.dummy;
					if (triple.getObject().getLiteral().toString().equalsIgnoreCase("sound")) return Program.sound;
					if (triple.getObject().getLiteral().toString().equalsIgnoreCase("rover")) return Program.rover;
					return Program.none;
				}
			}

		} catch (Exception e) {
			logger.warn(e);
		}

		return Program.none;
	}


	private static boolean checkStatus() {
		String url = "http://scc-cnor-129py5.scc.kit.edu:8080/marmotta/resource/RCX-PIMP";

		List<Triple> triples = new ArrayList<Triple>();

		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			//add accept header
			//con.setRequestProperty("Accept", "application/rdf+xml");
			con.setRequestProperty("Accept", "text/turtle");

			int responseCode = con.getResponseCode();
			logger.info("\nSending 'GET' request to URL : " + url);
			logger.info("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			StringBuffer response = new StringBuffer();

			//String inputLine;
			//		while ((inputLine = in.readLine()) != null) {
			//			response.append(inputLine);
			//		}
			//		
			//		
			Model model = ModelFactory.createDefaultModel();
			model.read(con.getInputStream(), null, "TTL");
			StmtIterator iter = model.listStatements();
			while (iter.hasNext()) {
				Statement statement = iter.next();
				triples.add(statement.asTriple());
				response.append(statement.toString());
			}

			in.close();

			con.disconnect();

			//print result
			logger.debug(response.toString());

			for (Triple triple : triples) {
				if (triple.getPredicate().getURI().equalsIgnoreCase("http://example.org/status")) {
					if (triple.getObject().getLiteral().toString().equalsIgnoreCase("on")) {
						return true;
					} else {
						return false;
					}
				}
			}

		} catch (Exception e) {
			logger.warn(e);
		}

		return false;
	}


	/**
	 * 
	 * @author root
	 *
	 */
	private class StreamGobbler extends Thread {
		InputStream is;

		// reads everything from is until empty. 
		public StreamGobbler(InputStream is) {
			this.is = is;
		}

		public void run() {
			try {

				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line=null;
				while ( (line = br.readLine()) != null) {
//					boolean isChanged = setIncoming(line);
//					System.out.println(line);   
//
//					if (isChanged) {
//						setChanged();
//						notifyObservers();
//					}
					logger.debug(line);

				}
			} catch (IOException ioe) {
				ioe.printStackTrace();  
			}
		}


	}
	
}
