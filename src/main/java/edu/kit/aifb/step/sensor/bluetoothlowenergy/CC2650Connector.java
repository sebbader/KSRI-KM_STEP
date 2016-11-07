package edu.kit.aifb.step.sensor.bluetoothlowenergy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.jena.rdf.model.Model;

import edu.kit.aifb.step.Config;
import edu.kit.aifb.step.sensor.AdministrationShell.IncomingDataServer;

public class CC2650Connector extends IncomingDataServer {

	private String incomingData;
	private Config config;
	private Model model;

	private boolean activeLightSensor = true;
	private int numberOfLoops = -1;
	private double timeBetweenPolls = 1.0;
	private boolean activeAccelerometer = false;
	private boolean activeTemperatureSensor = false;
	private boolean activeHumiditySensor = true;
	private boolean activeMagnetometer = false;
	private boolean activeBarometer = true;
	private boolean activeGyroscope = false;
	private boolean activeKeypressSensor = false;
	private boolean activeAll = false;


	/**
	 * Constructor for the CC2650Connector class.
	 * For now, the exact BLE address in hex format is necessary
	 * example: deviceMAC = "B0:B4:48:BC:CA:87"
	 * @param deviceMAC
	 */
	public CC2650Connector(Config config) {
		this.config = config;
	}

	public void setLightSensor (boolean value) {
		this.activeLightSensor = value;
	}

	public void setNumberOfLoops (int value) {
		this.numberOfLoops = value;
	}
	public void setTimeBetweenPolls (double value) {
		this.timeBetweenPolls = value;
	}

	public void setAccelerometer (boolean value) {
		this.activeAccelerometer = value;
	}

	public void setHumiditySensor (boolean value) {
		this.activeHumiditySensor = value;
	}

	public void setTemperatureSensor (boolean value) {
		this.activeTemperatureSensor = value;
	}

	public void setMagnetometer (boolean value) {
		this.activeMagnetometer = value;
	}

	public void setBarometer (boolean value) {
		this.activeBarometer = value;
	}

	public void setGyroscope (boolean value) {
		this.activeGyroscope = value;
	}

	public void setKeypressSensor (boolean value) {
		this.activeKeypressSensor = value;
	}

	public void setAll (boolean value) {
		this.activeAll = value;
	}


	@Override
	public void startServer() {

		try {

			//declare the call of the Python Script
			ArrayList<String> commands = new ArrayList<String>();
			commands.add("python");
			commands.add("src/main/python/connectCC2650.py");

			//add arguments
			commands.add("-t " + timeBetweenPolls);
			if (numberOfLoops > -1) commands.add("-n " + numberOfLoops);
			if (activeTemperatureSensor) commands.add("-T");
			if (activeHumiditySensor) commands.add("-H");
			if (activeMagnetometer) commands.add("-M");
			if (activeLightSensor) commands.add("-L");
			if (activeAccelerometer) commands.add("-A");
			if (activeBarometer) commands.add("-B");
			if (activeGyroscope) commands.add("-G");
			if (activeKeypressSensor) commands.add("-K");
			if (activeAll) commands.add("--all");

			commands.add(config.getMAC());

			String[] commandArray = new String[commands.size()];
			commands.toArray(commandArray);
			//System.out.println("Prepared command for shell:\n" + commands.toString());

			//start the execution
			Runtime rt = Runtime.getRuntime();
			//Process proc = rt.exec(commandArray);
			//Process proc = rt.exec("python3.4 src/main/python/connectCC2650.py -t 1 -n 2 B0:B4:48:BC:CA:87");
			//Process proc = rt.exec("python -c 'import bluepy'");
			//String[] x = {"sh", "-c", "$@|sh", ".", "echo", "echo", "$PYTHONPATH"};
			Process proc = rt.exec(commandArray);
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

	@Override
	public String getSendingDevice() {
		return config.getMAC();
	}


	@Override
	public String getIncomingData() {
		return incomingData;
	}

	private boolean setIncomingData(String rawData) {
		boolean isChanged = false;
		
		// TODO change this VERY dirty approach!
		String[] dataPoint = rawData.split("  ");
		if (dataPoint.length < 2) dataPoint = rawData.split(" ', \\(");

		if (dataPoint.length < 2) return isChanged;
		if (dataPoint[0].equalsIgnoreCase("")) return isChanged;
		if (dataPoint[1].equalsIgnoreCase("")) return isChanged;

		String unit = dataPoint[0];
		String value = dataPoint[1];

		String json = "{\"" + unit + "\":\"" + value + "\"}";
		this.incomingData = json;
		isChanged = true;

		return isChanged;
	}


	private boolean setIncoming(String data) {
		boolean isChanged = false;

		if (data.startsWith("Conn")) {
			//setSendingDevice(data.split(" ")[2]);
		} if (data.startsWith("finish")) {
			//ignore
		}	else {
			setIncomingData(data);
			isChanged = true;
		}

		return isChanged;
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
					boolean isChanged = setIncoming(line);
					System.out.println(line);   

					if (isChanged) {
						setChanged();
						notifyObservers();
					}

				}
			} catch (IOException ioe) {
				ioe.printStackTrace();  
			}
		}


	}


	@Override
	public void run() {
		startServer();
	}
}
