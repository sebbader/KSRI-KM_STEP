package edu.kit.aifb.step.sensor.AdministrationShell;

import java.io.IOException;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.NodeIterator;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;

import edu.kit.aifb.step.Config;

public class ConfigLoader {

	public static Config readConfig(String configFile) throws IOException {

		Config config = new Config();

		Model model = ModelFactory.createDefaultModel();
		model.read(configFile);

		//Property rdfsType = model.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
		//RDFNode	stepAdministrationShell = model.createResource("http://km.aifb.kit.edu/projects/step/AdministrationShell");
		ResIterator iter = model.listResourcesWithProperty(model.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), model.createResource("http://km.aifb.kit.edu/projects/step/AdministrationShell"));
		if (!iter.hasNext()) throw new IOException("Necessary resource of class <http://km.aifb.kit.edu/projects/step/AdministrationShel> could not be found!");
		Resource administrationShell = iter.next();

		NodeIterator nIter = model.listObjectsOfProperty(administrationShell, model.createProperty("http://example.org/hasInputParameter"));
		if (!nIter.hasNext()) throw new IOException("Necessary InputParameters for " + administrationShell.toString() + " could not be found!");
		while (nIter.hasNext()) {
			Resource inputParameter = (Resource) nIter.next();
			loadInputParameter(model.listStatements(inputParameter, null, (RDFNode) null), config);
		}
		
		if (config.getDevice() == null) throw new IOException("Could not identify any device identifier in " + configFile + "!");
		if (!model.contains((Resource) config.getDevice(), model.createProperty("http://example.org/hasMAC")) ) throw new IOException("Could not identify any MAC for " + config.getDevice().toString() + " in " + configFile + "!");
		String mac = model.listObjectsOfProperty((Resource) config.getDevice(), model.createProperty("http://example.org/hasMAC")).next().toString();
		config.setMac(mac);
		
		return config;
	}


	private static void loadInputParameter(StmtIterator iter, Config config) {
		Model model = ModelFactory.createDefaultModel();

		while (iter.hasNext()) {
			Statement stmt = iter.next();
			if (stmt.getPredicate().equals(model.createProperty("http://example.org/hasNamespace"))) {
				config.setNamespace(stmt.getString());
			} else if (stmt.getPredicate().equals(model.createProperty("http://example.org/hasMode"))) {
				config.setMode(stmt.getObject());
			} else if (stmt.getPredicate().equals(model.createProperty("http://example.org/hasDevice"))) {
				config.setDevice(stmt.getObject());
			} else if (stmt.getPredicate().equals(model.createProperty("http://example.org/hasLogLevel"))) {
				config.setLogLevel(stmt.getString());
			} else if (stmt.getPredicate().equals(model.createProperty("http://example.org/hasLdpContainer"))) {
				config.setLDPContainer(stmt.getObject().toString());
			} else if (stmt.getPredicate().equals(model.createProperty("http://example.org/hasUsername"))) {
				config.setUser(stmt.getObject().toString());
			} else if (stmt.getPredicate().equals(model.createProperty("http://example.org/hasPassword"))) {
				config.setPwd(stmt.getObject().toString());
			}

		}
	}

}
