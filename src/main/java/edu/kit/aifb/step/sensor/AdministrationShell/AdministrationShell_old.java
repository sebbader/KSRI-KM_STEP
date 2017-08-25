package edu.kit.aifb.step.sensor.AdministrationShell;

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
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import edu.kit.aifb.step.StepLogger;
import edu.kit.aifb.step.sensor.bluetoothlowenergy.CC2650Connector;
import edu.kit.aifb.step.sensor.connector.DatabaseConnector;
import edu.kit.aifb.step.sensor.converter.JsonConverter;

public class AdministrationShell_old implements Observer {

	private DatabaseConnector connector;
	private HashMap<String, Object> deviceCharacteristics;

	public static Logger logger;

	private static int mode = 0;
	private static String dbServer = "";
	private static String dbPort = "";
	private static String namespace;
	private static String dbUser = "";
	private static String dbPwd = "";
	private static String dbDataGraph = "";
	private static List<String> devices;


	public static void main(String[] args) {

		logger = StepLogger.setLogger();
		


		try {

			Options options = new Options();
			options.addOption("m", "mode", true, "1: Bluetooth mode   2: BLE mode");
			options.addOption("d", "devices", true, "if in BLE mode the device BLE MAC(s) is (are) required. Multiple entries are seperated using '&'");
			options.addOption("v", "virtuoso-host", true, "ipv4 of virtuoso");
			options.addOption("p", "virtuoso-port", false, "port of virtuoso");
			options.addOption("n", "namespace", true, "namespace of resources");
			options.addOption("u", "user", true, "virtuoso user name");
			options.addOption("P", "password", true, "virtuoso password");
			options.addOption("g", "graph", true, "graph url for data insert");
			options.addOption("l", "log-level", true, "the lower bounder for showing log messages");

			CommandLineParser parser = new DefaultParser();
			CommandLine cmd = parser.parse(options, args);

			if (!cmd.hasOption("m")) {
				printHelp();
				System.exit(1);
			} else {
				String m = cmd.getOptionValue("m");
				if (m.equalsIgnoreCase("1")) {
					mode = 1;
				} else if (m.equalsIgnoreCase("2")) {
					mode = 2;
				} else {
					printHelp();
					System.exit(1);
				}
			}

			if ((mode == 2) && (!cmd.hasOption("d")) ) {
				printHelp();
				System.exit(1);
			} else if (cmd.hasOption("d")) {
				devices = Arrays.asList( cmd.getOptionValue("d").split("&") );
			}

			if (!cmd.hasOption("v") ) {
				printHelp();
				System.exit(1);
			} else {
				dbServer = cmd.getOptionValue("v");
			}

			if (!cmd.hasOption("n") ) {
				printHelp();
				System.exit(1);
			} else {
				namespace = cmd.getOptionValue("n");
			}

			if (!cmd.hasOption("p") ) {
				printHelp();
				System.exit(1);
			} else {
				dbPort = cmd.getOptionValue("p");
			}

			if (!cmd.hasOption("u") ) {
				printHelp();
				System.exit(1);
			} else {
				dbUser = cmd.getOptionValue("u");
			}

			if (!cmd.hasOption("P") ) {
				printHelp();
				System.exit(1);
			} else {
				dbPwd = cmd.getOptionValue("P");
			}

			if (!cmd.hasOption("g") ) {
				printHelp();
				System.exit(1);
			} else {
				dbDataGraph = cmd.getOptionValue("g");
			}

			if (cmd.hasOption("l") ) {
				String level = cmd.getOptionValue("l");
				if (level.equalsIgnoreCase("all")) logger.setLevel(Level.ALL);
				if (level.equalsIgnoreCase("trace")) logger.setLevel(Level.TRACE);
				if (level.equalsIgnoreCase("debug")) logger.setLevel(Level.DEBUG);
				if (level.equalsIgnoreCase("info")) logger.setLevel(Level.INFO);
				if (level.equalsIgnoreCase("warn")) logger.setLevel(Level.WARN);
				if (level.equalsIgnoreCase("error")) logger.setLevel(Level.ERROR);
				if (level.equalsIgnoreCase("fatal")) logger.setLevel(Level.FATAL);
				if (level.equalsIgnoreCase("off")) logger.setLevel(Level.OFF);
			} else {
				logger.setLevel(Level.INFO);
			}

			logger.debug("\nParameters:\nBluetooth mode: "  + mode 
					+ "\ndevices: " + devices
					+ "\nRDF-DataStore host: " + dbServer
					+ "\nRDF-DataStore port: " + dbPort
					+ "\nRDF-DataStore user: " + dbUser
					+ "\nRDF-DataStore password: " + dbPwd
					+ "\nsata graph name: " + dbDataGraph
					);

			for (String device : devices) {
				AdministrationShell_old shell = new AdministrationShell_old(mode, dbServer, dbPort, dbUser, dbPwd, dbDataGraph);
	//			shell.startup(mode, device);
			}

		} catch (Exception e) {
			System.out.println("error");
			logger.fatal(e);
			printHelp();
			System.exit(1);
		}

	}



	public AdministrationShell_old(int mode, String dbServer, String dbPort, String dbUser, String dbPwd, String dbDataGraph) {
		//this.connector = new VirtuosoConnector(dbServer, dbPort, dbUser, dbPwd, dbDataGraph);
		//this.connector = new LinkedDataPlatformConnector(dbServer, dbPort, dbUser, dbPwd, dbDataGraph);
		logger.trace("AdministrationShell started");
	}


/*	public void startup(int mode, String bleDeviceMAC) {

		if (mode == 1) {

			BluetoothServiceRegistration server = new BluetoothServiceRegistration();
			server.addObserver(this);
			server.startServer();

		} else if (mode == 2){

			logger.debug("Try starting BLE connector...");

			// container for device specific information
			deviceCharacteristics = new HashMap<String, Object>();
			List<String> relations = new ArrayList<String>();
			// necessary technical information
			deviceCharacteristics.put("id", bleDeviceMAC);
			deviceCharacteristics.put("url", addSlash(namespace) + bleDeviceMAC.replace(":", "-"));
			deviceCharacteristics.put("namespace", addSlash(namespace));


			// additional information
			deviceCharacteristics.put("http://www.w3.org/2006/vcard/ns#Address", "Sebastians office");
			relations.add("http://www.w3.org/2006/vcard/ns#Address");
			deviceCharacteristics.put("http://aifb.kit.edu/step/hasType", "http://www.ti.com/sensortag");
			relations.add("http://aifb.kit.edu/step/hasType");

			deviceCharacteristics.put("relations", relations);

			logger.trace("BLE device characteristics: " + deviceCharacteristics.toString());

			CC2650Connector server = new CC2650Connector(deviceCharacteristics);
			server.addObserver(this);
			server.setBarometer(true);
			server.setTemperatureSensor(true);
			server.setNumberOfLoops(10);
			server.setTimeBetweenPolls(1.0);
			(new Thread(server) ).start();;

			logger.debug("BLE connector up and running");
		}

	}
*/

	public static String addSlash(String text) {
		if (!text.endsWith("/")) text = text + "/";
		return text;
	}


	public void update(Observable o, Object arg) {

		logger.trace("New data received: ");

		IncomingDataServer server = (IncomingDataServer) o;
		String data = server.getIncomingData();
		//		String device = server.getSendingDevice();

		logger.trace("Device " + server + " has sent: " + data);

		if (isValidJSON(data)) {
			JsonObject jsonData = JSON.parse(data);

//			JsonConverter converter = new JsonConverter( deviceCharacteristics );
//			List<Triple> triples = converter.convertToRDF(jsonData);
//
////			for (Triple triple : triples) {
////				connector.sendTriple(triple);
////			}
//			
//			connector.sendTriples(triples);
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
