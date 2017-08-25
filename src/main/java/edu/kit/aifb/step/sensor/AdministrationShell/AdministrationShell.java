package edu.kit.aifb.step.sensor.AdministrationShell;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.jena.atlas.json.JSON;
import org.apache.jena.atlas.json.JsonObject;
import org.apache.jena.graph.Triple;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import edu.kit.aifb.step.Config;
import edu.kit.aifb.step.SensorAccessMode;
import edu.kit.aifb.step.StepLogger;
import edu.kit.aifb.step.sensor.bluetoothlowenergy.CC2650Connector;
import edu.kit.aifb.step.sensor.connector.DatabaseConnector;
import edu.kit.aifb.step.sensor.converter.JsonConverter;

public class AdministrationShell implements Observer {

	private DatabaseConnector connector;

	Config config;
	long last = 0l;
	String data = "";

	public static void main(String[] args) {


		// load configurations
		try {

			AdministrationShell adminShell = new AdministrationShell();
			adminShell.startup();

		} catch (Exception e) {
			System.out.println("error");
			StepLogger.getLogger().fatal(e);
			printHelp();
			System.exit(1);
		}

	}



	public AdministrationShell() throws IOException {
		
		config = ConfigLoader.readConfig("config/config.ttl");
		StepLogger.setLogger();
		StepLogger.getLogger().setLevel(config.getLogLevel());
		
		//this.connector = new VirtuosoConnector(dbServer, dbPort, dbUser, dbPwd, dbDataGraph);
//		this.connector = new LinkedDataPlatformConnector(config);
		StepLogger.getLogger().trace("AdministrationShell started");
	}


	public void startup() {

		if (config.getMode() == SensorAccessMode.BLUETOOTH) {

			BluetoothServiceRegistration server = new BluetoothServiceRegistration();
			server.addObserver(this);
			server.startServer();

		} else if (config.getMode() == SensorAccessMode.BLE){

			StepLogger.getLogger().debug("Try starting BLE connector...");


			CC2650Connector server = new CC2650Connector(config);
			server.addObserver(this);
			server.setBarometer(true);
			server.setTemperatureSensor(true);
			server.setNumberOfLoops(10);
			server.setTimeBetweenPolls(1.0);
			(new Thread(server) ).start();

			StepLogger.getLogger().debug("BLE connector up and running");
		}

	}


	public static String addSlash(String text) {
		if (!text.endsWith("/")) text = text + "/";
		return text;
	}


	public void update(Observable o, Object arg) {

		StepLogger.getLogger().debug("New data received: ");
		IncomingDataServer server = (IncomingDataServer) o;
		
		//triggerWaiting(server.getIncomingData());
		String incoming_data = server.getIncomingData();
		StepLogger.getLogger().debug("Device " + server + " has sent: " + incoming_data);
		
		writeData(incoming_data);
	}
	
	
	private void writeData(String data) {

		if (isValidJSON(data)) {
			JsonObject jsonData = JSON.parse(data);

			JsonConverter converter = new JsonConverter( config );
			Model model = ModelFactory.createDefaultModel();
			model.add(converter.convertToRDF(jsonData));

			// additional information
			model.add(model.createStatement((Resource) config.getDevice(), 
					model.createProperty("http://www.w3.org/2006/vcard/ns#Address"), 
					model.createLiteral("Sebastians office") ) ); 
			model.add(model.createStatement((Resource) config.getDevice(), 
					model.createProperty("http://www.w3.org/2000/01/rdf-schema#type"), 
					model.createResource("http://www.ti.com/sensortag") ) ); 
			
			StepLogger.getLogger().debug("Converted incoming JSON:" + data + "\nto " + model.listStatements());
			connector.sendTriples(model);
		} else {
			StepLogger.getLogger().warn("Message was rejected - no JSON:" + data);
		}
		
	}

	public boolean isValidJSON(String string) {
		try {
			JSON.parse(string);
		} catch (Exception ex) {
			// potential problem with JSON Array
			return false;
		}
		return true;
	}

	private static void printHelp(){
		System.exit(1);
	}
}
