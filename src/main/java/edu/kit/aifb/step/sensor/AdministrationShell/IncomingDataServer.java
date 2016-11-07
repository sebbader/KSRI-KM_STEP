package edu.kit.aifb.step.sensor.AdministrationShell;

import java.util.Observable;


public abstract class IncomingDataServer extends Observable implements Runnable {
	
	public abstract void startServer();
	public abstract String getSendingDevice();
	public abstract String getIncomingData();

}
