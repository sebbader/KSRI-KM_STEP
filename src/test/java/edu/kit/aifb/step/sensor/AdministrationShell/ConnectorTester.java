package edu.kit.aifb.step.sensor.AdministrationShell;

import edu.kit.aifb.step.StepLogger;
import edu.kit.aifb.step.sensor.AdministrationShell.AdministrationShell;
import edu.kit.aifb.step.sensor.connector.VirtuosoConnector;

public class ConnectorTester {

	public static void main(String[] args) {
		
		StepLogger.setLogger();
		
		// TODO Auto-generated method stub
		VirtuosoConnector connector = new VirtuosoConnector("172.22.177.6", "1111", "step", "FirstStep", "http://dummy");
		connector.sendTriple("http://dummy/subj", "http://dummy/pred", "http://dummy/obj");
		
	}
}
