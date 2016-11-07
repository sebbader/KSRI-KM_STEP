package edu.kit.aifb.step.sensor.simulator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

/**
 * Hello world!
 *
 */
public class ClientStarter implements Observer {
	
	private static HashMap<Object, String> services;
	private static BluetoothDeviceFinder finder;
	private static String client = "http://10.42.0.1/DummySensor";

	public static void main( String[] args )
	{

		// find devices and PUSH services
		findBluetoothDevicesAndServices();
		
		// create a dummy sensor with update interval 1 sec
		Sensor sensor = new Sensor(1000L);
		ClientStarter client = new ClientStarter();
		sensor.addObserver(client);
		
		// start sending random update values to Bluetooth server
		if (!services.isEmpty()) sensor.startSensing();

	}

	private static void findBluetoothDevicesAndServices() {
		finder = new BluetoothDeviceFinder();
		finder.find();
		services = finder.getServices();
	}

	public void update(Observable o, Object arg) {
		Sensor sensor = (Sensor) o;
		try {
			sendUpdate("{\"DummySensor\":[{\"temperature\":" + sensor.getTemperature() + "}, {\"pressure\":" + sensor.getPressure() + "}]}", client);
		} catch (IOException e) {
			e.printStackTrace();
			sensor.stop = true;
			
			findBluetoothDevicesAndServices();
			if (!services.isEmpty()) sensor.startSensing();
		}
	}

	private void sendUpdate(String message, String sender) throws IOException {
		if (!services.isEmpty()) {
			Iterator<Object> iter = services.keySet().iterator();
			while (iter.hasNext()) {
				Object key = iter.next();
				finder.sendMessage(services.get(key), message, sender);
			}
		}
	}
	
}
